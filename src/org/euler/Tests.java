package org.euler;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Tests {

    /**
     *
     * Notes:
     *  - I am using java built-in assert for testing instead of j-unit or similar to keep project dependencies
     *    to the minimum. In a real project, we would use a testing library.
     *  - Java assert are disabled by default. To enable them, run this class with -ea option.
     *
     * **/
    public static void main(String[] args) {

        System.out.println("Testing PrimeSummation");
        test_PrimeSummation_isPrime();
        test_PrimeSummation_primeSummation();

        System.out.println("Testing FibonacciNumber");
        test_FibonacciNumber_fibonacciIndex();

        System.out.println("Testing BasePalindrome");
        test_BasePalindrome_isPalindrome();
        test_BasePalindrom_sumAllDoublePalindrome();
    }

    static void test_PrimeSummation_isPrime() {
        assert PrimeSummation.isPrime(2);
        assert PrimeSummation.isPrime(3);
        assert PrimeSummation.isPrime(13);
        assert PrimeSummation.isPrime(929);

        assert !PrimeSummation.isPrime(0);
        assert !PrimeSummation.isPrime(1);
        assert !PrimeSummation.isPrime(819);

        try {
            PrimeSummation.isPrime(-1);
        } catch (IllegalArgumentException e) {
            assert e != null;
            assert e.getMessage().equals("Only positive values allowed");
        }
    }

    static void test_PrimeSummation_primeSummation() {
        assert PrimeSummation.primeSummation(0) == 0;
        assert PrimeSummation.primeSummation(1) == 0;
        assert PrimeSummation.primeSummation(2) == 0;
        assert PrimeSummation.primeSummation(3) == 2;
        assert PrimeSummation.primeSummation(4) == 5;
        assert PrimeSummation.primeSummation(10) == 17;
        assert PrimeSummation.primeSummation(100) == 1060;
        assert PrimeSummation.primeSummation(2000000) == 142913828922L;

        try {
            PrimeSummation.primeSummation(-1);
        } catch (IllegalArgumentException e) {
            assert e != null;
            assert e.getMessage().equals("Only positive values allowed");
        }
    }

    static void test_FibonacciNumber_fibonacciIndex() {
        assert(FibonacciNumber.fibonacciIndex(new BigInteger("0"))) == 0;
        assert(FibonacciNumber.fibonacciIndex(new BigInteger("1"))) == 1;
        assert(FibonacciNumber.fibonacciIndex(new BigInteger("2"))) == 3;
        assert(FibonacciNumber.fibonacciIndex(new BigInteger("21"))) == 8;
        assert(FibonacciNumber.fibonacciIndex(new BigInteger("144"))) == 12;
        assert(FibonacciNumber.fibonacciIndex(new BigDecimal("0.1e3").toBigInteger())) == 12;
        assert(FibonacciNumber.fibonacciIndex(new BigDecimal("0.1e10").toBigInteger())) == 45;
        assert(FibonacciNumber.fibonacciIndex(new BigDecimal("0.1e1000").toBigInteger())) == 4782;

        try {
            FibonacciNumber.fibonacciIndex(new BigInteger("-1"));
        } catch (IllegalArgumentException e) {
            assert e != null;
            assert e.getMessage().equals("Upper limit should be positive");
        }
    }

    static void test_BasePalindrome_isPalindrome() {
        assert DoubleBasePalindrome.isPalindrome("madam");
        assert DoubleBasePalindrome.isPalindrome("1101011");
        assert DoubleBasePalindrome.isPalindrome("969");

        assert !DoubleBasePalindrome.isPalindrome("test");
        assert !DoubleBasePalindrome.isPalindrome("100100");
        assert !DoubleBasePalindrome.isPalindrome("669");

        assert !DoubleBasePalindrome.isPalindrome(null);
        assert !DoubleBasePalindrome.isPalindrome("");
    }

    static void test_BasePalindrom_sumAllDoublePalindrome() {
        assert DoubleBasePalindrome.sumAllDoublePalindrome(0) == 0;
        assert DoubleBasePalindrome.sumAllDoublePalindrome(1) == 0;
        assert DoubleBasePalindrome.sumAllDoublePalindrome(2) == 1;
        assert DoubleBasePalindrome.sumAllDoublePalindrome(600) == 1055;
        assert DoubleBasePalindrome.sumAllDoublePalindrome(1000000) == 872187;

        assert DoubleBasePalindrome.sumAllDoublePalindrome(-1) == 0;
    }
}
