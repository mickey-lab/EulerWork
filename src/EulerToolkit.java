import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.stream.IntStream;

public class EulerToolkit {

    //tries using the https://en.wikipedia.org/wiki/Prime-counting_function
    public static int[] getPrimesMessy(int x) {
        int primeCount = (int) Math.ceil(x / Math.log(x));
        int[] primes = new int[primeCount];
        primes[0] = 2;
        primes[1] = 3;
        int counter = 2;
        boolean isPrime;
        for (int i = 2; i <= x; i++) {
            isPrime = true;
            for (int j = 0; j < counter; j++) {
                if (i % primes[j] == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primes[counter] = i;
                counter++;
            }
        }
        return primes;
    }

    //Naive approach
    public static int[] getDivisors(int x) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.floor(Math.sqrt(x)); i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != x / i) divisors.add(x / i);
            }
        }
        int[] divisorsArr = new int[divisors.size()];
        for (int i = 0; i < divisors.size(); i++) {
            divisorsArr[i] = divisors.get(i);
        }
        Arrays.sort(divisorsArr);
        return divisorsArr;
    }

    public static int[] getDivisorsProper(int x) {
        int[] divisors = getDivisors(x);
        return Arrays.copyOfRange(divisors, 0, divisors.length - 1);
    }

    //from problem 23
    public static boolean isPerfect(int x) {
        return IntStream.of(getDivisorsProper(x)).sum() == x;
    }

    public static boolean isAbundant(int x) {
        return IntStream.of(getDivisorsProper(x)).sum() > x;
    }

    public static boolean isDeficient(int x) {
        return IntStream.of(getDivisorsProper(x)).sum() < x;
    }

    public static int[] getDivisorsFast(int x) {
        int[] divisors = new int[x];
        int[] primes = getPrimes(x);


        return divisors;
    }

    public static LinkedHashMap primeFactorise(int x) {
        LinkedHashMap<Integer, Integer> primes = new LinkedHashMap<>();
        for (Integer i : getPrimes(x)) {
            primes.put(i, 0);
            int temp = x;
            while (temp % i == 0) {
                primes.put(i, primes.get(i) + 1);
                temp /= i;
            }
        }
        Integer[] keys = primes.keySet().toArray(new Integer[primes.size()]);
        for (int i : keys) {
            if (primes.get(i) == 0) {
                primes.remove(i);
            }
        }
        return primes;
    }

    public static int[] getPrimes(int x) {
        //Use Sieve to get array where the value at the index of a number is true if prime
        boolean[] isPrime = new boolean[x];
        for (int a = 2; a < x; a++) {
            isPrime[a] = true;
        }
        for (int i = 0; i < Math.ceil(Math.sqrt(x)); i++) {
            if (isPrime[i]) {
                for (int j = i + 1; j < x; j++) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        //count prime numbers
        int primeCount = 0;
        for (boolean b : isPrime) {
            if (b) {
                primeCount++;
            }
        }
        int[] primes = new int[primeCount];
        int counter = 0;
        //place prime nums in the array
        for (int n = 0; n < x; n++) {
            if (isPrime[n]) {
                primes[counter] = n;
                counter++;
            }
        }
        return primes;
    }

    public static int[][] matrixInput(String fileName) throws IOException {
        //get matrix file path
        String path = System.getProperty("user.dir");
        String file = path + "/" + fileName;
        //count number of lines in file (number of rows of matrix)
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lineCount = (int) reader.lines().count();
        //reset to beginning of file
        reader = new BufferedReader(new FileReader(file));
        //insert values into matrix 2-D array
        int[][] matrix = new int[0][0];
        String[] temp;
        boolean initialized = false;
        for (int i = 0; i < lineCount; i++) {
            temp = reader.readLine().split(",");
            if (!initialized) {
                matrix = new int[lineCount][temp.length];
                initialized = true;
            }
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return matrix;
    }

    public static int[][] matrixTranspose(int[][] matrix) {
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static int getArrayMin(int[] x) {

        Integer[] integerArr = new Integer[x.length];
        for (int i = 0; i < x.length; i++) {
            integerArr[i] = Integer.valueOf(x[i]);
        }
        return Collections.min(Arrays.asList(integerArr));
    }

    public static int getArrayMax(int[] x) {

        Integer[] integerArr = new Integer[x.length];
        for (int i = 0; i < x.length; i++) {
            integerArr[i] = Integer.valueOf(x[i]);
        }
        return Collections.max(Arrays.asList(integerArr));
    }

}
