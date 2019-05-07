package org.euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;

/**
 * Problem 25: 1000-digit Fibonacci number
 * See https://projecteuler.net/problem=25
 *
 * Problem Statement
 * =================
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 * =================
 *
 * • A sample of the output : 4782
 *
 * • Why you chose the problems you did : After prime numbers, this seemed like a natural follow up. It's was simple
 *   enough that it could be coded quickly
 *
 * • A description of the process you followed in solving the problem: To solve this problem, I just generate a list of
 *   fibonacci number until when the generated digit contains 100 digits while keeping count of how many times a
 *   fibonacci number was generated. At the end, I just return the count.
 *   While doing this exercise, I learned other methods for computing fibonacci number that are faster,
 *   but not necessary easy to read/understand. The method I implemented is the middle ground. It's not as simple as
 *   the recursive mathematical formula, but not as complex as other methods described in [1]
 *
 * • What reference sources you used, if any: .
 *   [1] https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 * • How much time you spent on the exercise: 1 hour
 */
public class FibonacciNumber {


    /**
     * Return the index of the first term in the fibonacci sequence above the the given upperLimit
     * @param upperLimit the upper limit
     * @return the fibonacci Index. See https://projecteuler.net/problem=25 for the definition of Fibonacci index
     */
    static int fibonacciIndex(BigInteger upperLimit) {
        if (upperLimit.signum() == -1) {
            throw new IllegalArgumentException("Upper limit should be positive");
        }
        BigInteger fibonacci = new BigInteger("1");
        BigInteger previous = new BigInteger("0");
        // handle base case
        if (upperLimit.toString().equals("0") || upperLimit.toString().equals("1")) {
            return Integer.parseInt(upperLimit.toString());
        }
        int index = 1;
        // compute regular fibonacci up to the upperLimit while tracking the index
        while (fibonacci.compareTo(upperLimit) < 0) {
            BigInteger next = previous.add(fibonacci);
            previous = fibonacci;
            fibonacci = next;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        final BigInteger UPPER_LIMIT =  new BigDecimal("0.1e1000").toBigInteger();
        Instant start = Instant.now();
        System.out.println("Result: " + fibonacciIndex(UPPER_LIMIT));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Execution time: " + duration.toMillis() + " ms");
    }
}
