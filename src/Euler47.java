//https://projecteuler.net/problem=47

public class Euler47 {

    public static void main(String[] args) {
        int searchSize = (int) Math.pow(10,6);
        //Cache of primes for prime factorization algorithm.
        // The primes only need to be up to sqrt() of the search size since they can only be less than the square root of the number.
        int[] primeInput = EulerToolkit.getPrimes((int) Math.sqrt(searchSize));
        //checks prime factorizations for every 4 consecutive integers
        for (int i = 1000; i < searchSize; i++) {
            if(EulerToolkit.primeFactorise(i,primeInput).size()==4 && EulerToolkit.primeFactorise(i+1,primeInput).size()==4 && EulerToolkit.primeFactorise(i+2,primeInput).size()==4 && EulerToolkit.primeFactorise(i+3,primeInput).size()==4){
                System.out.println("First Integer:"+i);
                break;
            }
        }
    }



}
