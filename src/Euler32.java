//https://projecteuler.net/problem=32

import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Euler32 problem = new Euler32();
        System.out.println("Sum: " + problem.findPanDigitals());
    }
}

public class Euler32 {
    private ArrayList<Integer> panDigits = new ArrayList<>();
    char[] singles = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int findPanDigitals() {
        int product;
        for (int i = 1; i < Math.pow(10, 4); i++) {
            for (int j = (int) Math.pow(10, Math.log10(i)); j < Math.pow(10, 5 - Math.log10(i)); j++) {
                product = i * j;
                if (panDigitals(i + String.valueOf(j) + product) && !panDigits.contains(product)) {
                    panDigits.add(product);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < panDigits.size(); i++) {
            sum += panDigits.get(i);
        }
        return sum;
    }

    public boolean panDigitals(String s) {
        if (s.length() != 9) {
            return false;
        }
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        for (int i = 0; i < 9; i++) {
            if (sArr[i] != singles[i]) {
                return false;
            }
        }
        return true;
    }


}
