//https://projecteuler.net/problem=23
/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.*/

import java.io.IOException;
import java.util.ArrayList;

public class Euler23 {

    public static void main(String[] args) throws IOException {
        System.out.println(sumNonAbundantSums());
    }

    public static int sumNonAbundantSums() throws IOException {
        //find all abundant numbers up to 28123
        ArrayList<Integer> abundantNums = new ArrayList<>();
        for (int i = 12; i <= 28123; i++) {
            if (EulerToolkit.isAbundant(i)) {
                abundantNums.add(i);
            }
        }
        //calculate which positive integers <= 28123 are sums of two abundant integers
        ArrayList<Integer> sumsOfAbundants = new ArrayList<>();
        int temp;
        for (int i = 24; i <= 28123; i++) {
            for (int j = 0; j < abundantNums.size(); j++) {
                temp = i - abundantNums.get(j);
                if (temp < 12) {
                    break;
                }
                if (EulerToolkit.isAbundant(temp)) {
                    sumsOfAbundants.add(i);
                    break;
                }
            }
        }
        //sum all the abundant sums
        int sum = 0;
        for (int x : sumsOfAbundants) {
            sum += x;
        }
        //sum all positive integers 1 to 28123 inclusive
        int sumOfAll = (1 + 28123) * (28123) / 2;
        //subtract sum of all abundant sums from sum of all pos.ints <= 28123 for answer
        return sumOfAll - sum;
    }

}
