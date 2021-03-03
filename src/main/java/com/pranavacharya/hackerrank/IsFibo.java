package com.pranavacharya.hackerrank;

import java.util.HashSet;
import java.util.Scanner;

public class IsFibo {

    private HashSet<Long> fibs;

    public IsFibo() {
        long a = 1;
        long b = 1;
        this.fibs = new HashSet();
        this.fibs.add(a);
        this.fibs.add(b);
        while (a < 1e10) {
            long c = a + b;
            this.fibs.add(c);
            a = b;
            b = c;
        }
    }

    private boolean isFibonacci(long n) {
        return this.fibs.contains(n);
    }

    public static void main(String args[]) {
        IsFibo fib = new IsFibo();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            if (fib.isFibonacci(n)) {
                sb.append("IsFibo").append("\n");
            } else {
                sb.append("IsNotFibo").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
