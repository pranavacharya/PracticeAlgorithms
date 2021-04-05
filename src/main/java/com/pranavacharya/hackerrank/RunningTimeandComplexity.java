package com.pranavacharya.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class RunningTimeandComplexity {

    HashSet<Integer> primes;

    RunningTimeandComplexity() {
        this.primes = generatePrime();
    }

    private HashSet<Integer> generatePrime() {
        HashSet<Integer> set = new HashSet();
        boolean[] arr = new boolean[200000000];
        for (int i = 2; i * i < arr.length; i++) {
            if (arr[i]) {
                continue;
            }
            for (int j = 2; i * j < arr.length; j++) {
                arr[i * j] = true;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                set.add(i);
            }
        }
        return set;
    }

    private boolean isPrime(int n) {
        return this.primes.contains(n);
    }

    public static void main(String[] args) {
        RunningTimeandComplexity rtc = new RunningTimeandComplexity();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            if (rtc.isPrime(n)) {
                sb.append("Prime").append("\n");
            } else {
                sb.append("Not prime").append("\n");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
