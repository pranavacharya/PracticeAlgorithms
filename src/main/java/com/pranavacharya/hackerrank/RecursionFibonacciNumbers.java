package com.pranavacharya.hackerrank;

public class RecursionFibonacciNumbers {

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String args[]) {
        RecursionFibonacciNumbers rfn = new RecursionFibonacciNumbers();
        System.out.println(rfn.fibonacci(30));
    }
}
