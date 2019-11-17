public class EulerToolkit {

    public static int[] getDivisors(int x){
        return new int[0];
    }

    //tries using the https://en.wikipedia.org/wiki/Prime-counting_function
    public static int[] getPrimesMessy(int x){
        int primeCount = (int) Math.ceil(x/Math.log(x));
        int[] primes = new int[primeCount];
        primes[0]=2;
        primes[1]=3;
        int counter = 2;
        boolean isPrime;
        for(int i = 2; i <= x; i++){
            isPrime = true;
            for(int j = 0; j < counter; j++){
                if(i%primes[j]==0){
                    isPrime = false;
                }
            }
            if(isPrime){primes[counter]=i; counter++;}
        }
        return primes;
    }

    public static int[] getPrimes(int x){
        //Use Sieve to get array where the value at the index of a number is true if prime
        boolean[] isPrime = new boolean[x];
        for(int a = 2; a<x; a++){isPrime[a] = true;}
        for(int i = 0; i < Math.ceil(Math.sqrt(x)); i++){
            if(isPrime[i]) {
                for (int j = i + 1; j < x; j++) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        //count prime numbers
        int primeCount = 0;
        for(boolean b : isPrime){
            if(b){primeCount++;}
        }
        int[] primes = new int[primeCount];
        int counter = 0;
        //place prime nums in the array
        for(int n = 0; n < x; n++){
            if(isPrime[n]){ primes[counter]=n; counter++;}
        }
        return primes;
    }

}
