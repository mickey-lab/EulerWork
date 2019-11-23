public class Euler41 {


    public static void main(String[] args) {
        int[] primes = EulerToolkit.getPrimes((int) Math.pow(10,7));
        int max = 0;
        for(int i : primes){
            if(EulerToolkit.panDigitals(String.valueOf(i), String.valueOf(i).length()) && i>max){
                max = i;
            }
        }
        System.out.println(max);
    }


}
