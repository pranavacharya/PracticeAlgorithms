package com.pranavacharya.hackerrank;

import java.util.Scanner;

public class RunningTimeandComplexity {

    private boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        RunningTimeandComplexity rtc = new RunningTimeandComplexity();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            if (rtc.isPrime(n)) {
                sb.append("Prime").append("\n");
            } else {
                sb.append("Not prime").append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
