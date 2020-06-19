package com.pranavacharya.hackerearth;

import java.util.Scanner;

public class Factorial {

    private int mod = 1000000007;

    private long[] factorial = new long[100000];

    public long factorial(int n) {
        return findFact(n);
    }

    public long findFact(int n) {
        if (n == 0) {
            return 1;
        } else {
            if (factorial[n] == 0) {
                factorial[n] = ((n % mod) * (findFact(n - 1) % mod)) % mod;
            }
            return factorial[n];
        }
    }

    public static void main(String args[]) {
        Factorial f = new Factorial();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            sb.append(f.factorial(n) + "\n");
        }
        System.out.println(sb.toString());
    }
}
