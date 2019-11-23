//https://projecteuler.net/problem=32

public class Euler38 {

    public static void main(String[] args) {
        Euler38 problem = new Euler38();
        System.out.println("Largest Pandigital Num: " + problem.findPanDigitals());
    }

    private int findPanDigitals() {
        String concat;
        int max = 0;
        for (int i = 1; i < Math.pow(10, 5); i++) {
            concat = "";
            for (int j = 1; j < 9 / (Math.log10(i) + 1) + 1; j++) {
                concat += i * j;
            }
            if (EulerToolkit.panDigitals(concat)) {
                if (Integer.parseInt(concat) > max) {
                    max = Integer.parseInt(concat);
                }
            }
        }

        return max;
    }


}
