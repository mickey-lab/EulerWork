//https://projecteuler.net/problem=32

import java.util.ArrayList;


public class Euler32 {

    public static void main(String[] args) {
        Euler32 problem = new Euler32();
        System.out.println("Sum: " + problem.findPanDigitals());
    }

    private ArrayList<Integer> panDigits = new ArrayList<>();

    private int findPanDigitals() {
        int product;
        for (int i = 1; i < Math.pow(10, 4); i++) {
            for (int j = (int) Math.pow(10, Math.log10(i)); j < Math.pow(10, 5 - Math.log10(i)); j++) {
                product = i * j;
                if (EulerToolkit.panDigitals(i + String.valueOf(j) + product) && !panDigits.contains(product)) {
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


}
