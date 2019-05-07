package org.euler;

import java.time.Duration;
import java.time.Instant;

/**
 * Problem 10: Summation of primes
 * See https://projecteuler.net/problem=10
 *
 * Problem Statement
 * =================
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 * ================
 * • A sample of the output : 142913828922
 *
 * • Why you chose the problems you did : This seemed like a good problem to start with. Easy enough to understand and
 *   code. Also because it is number 10 to satisfy the test requirement.
 *
 * • A description of the process you followed in solving the problem: To solve this problem, I just generate
 *   numbers from from 3 to two million skipping even numbers. For each generated number, I check if the number is
 *   prime in which case I add it to the sum. To check the primality of the number, I implemented the simple method
 *   described in [1]
 *
 * • What reference sources you used, if any: While doing this exercise, I learned that there are many primality test
 *   methods. Some more sophisticated than others. I've implemented the simple method described here
 *   [1] https://en.wikipedia.org/wiki/Primality_test
 *
 * • How much time you spent on the exercise: 1 hour
 *
 */

public class PrimeSummation {

    /**
     * Determines if a number is prime or not
     * @param number the number to check
     * @throws IllegalArgumentException if given a negative number
     * @return true if number is prime, false otherwise
     */
    static boolean isPrime(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only positive values allowed");
        }
        if (number <= 3) {
            return number > 1;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number ; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Find the sum of all the primes below the given limit
     * @param upperLimit the upper limit
     * @return the sum of all the primes below upperLimit
     */
    static long primeSummation(int upperLimit) {
        if (upperLimit < 0) {
            throw new IllegalArgumentException("Only positive values allowed");
        }
        if (upperLimit <= 2) {
            return 0;
        }

        long sum = 2; // initialize to 2 (the first prime)

        // small optimization: We can skip all even numbers
        for (int i = 3; i < upperLimit; i += 2) {
            if (isPrime(i)) {
                sum+=i;
            }
        }
        return sum;
    }

    public static void main(String [] args) {
        final int UPPER_LIMIT = 2000000;
        Instant start = Instant.now();
        System.out.println("Result: " + primeSummation(UPPER_LIMIT));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Execution time: " + duration.toMillis() + " ms");
    }
}
