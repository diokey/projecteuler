package org.euler;

import java.time.Duration;
import java.time.Instant;

/**
 * Problem 36: Double-base palindromes
 * See https://projecteuler.net/problem=36
 *
 * Problem Statement
 * =================
 *
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 * =================
 *
 * • A sample of the output : 872187
 *
 * • Why you chose the problems you did : I chose this problem because I think palindromes are fun [2] and that the
 *   exercise seemed simple enough to code quickly
 *
 * • A description of the process you followed in solving the problem: To solve this problem, I convert the number into
 *   it's string and binary representation, then check if they are both palindromes. I do this from 0 to the upper limit
 *   (one million). I've decided to use the built-in library function for simplicity to convert to binary format
 *   and to reverse a string
 *
 * • What reference sources you used, if any: .
 *   [1] https://docs.oracle.com/javase/7/docs/api/java/lang/Integer.html#toBinaryString(int)
 *   [2] http://norvig.com/palindrome.html
 *
 * • How much time you spent on the exercise: 30 min
 */
public class DoubleBasePalindrome {

    /**
     * Determines if the given word is a palindrome
     * A palindrome is a a word, phrase, or sequence that reads the same backward as forward,
     * @param word the string to check
     * @return true if word is a palindrome, false otherwise
     */
    static boolean isPalindrome(String word) {
        if (word == null || word.equals("")) {
            return false;
        }
        String reversedWord = new StringBuilder(word).reverse().toString();
        return word.equals(reversedWord);
    }

    /**
     * Finds the sum of all numbers less than the upperLimit which are palindromic in base 10 and base 2
     * @param upperLimit the upperLimit
     * @return the sum of double base palindrome below upperLimit
     */
    static long sumAllDoublePalindrome(int upperLimit) {
        long sum = 0;
        for (int i = 0; i < upperLimit; i++) {
            // convert to binary
            String binaryString = Integer.toBinaryString(i);
            // convert to string
            String integerString = Integer.toString(i);
            boolean isDigitPalindrome = isPalindrome(integerString);
            boolean isBinaryPalindrome = isPalindrome(binaryString);
            if (isDigitPalindrome && isBinaryPalindrome) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String [] args) {
        final int UPPER_LIMIT = 1000000;
        Instant start = Instant.now();
        System.out.println("Result: " + sumAllDoublePalindrome(UPPER_LIMIT));
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Execution time: " + duration.toMillis() + " ms");
    }

}
