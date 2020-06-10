package com.pranavacharya.cses;

import java.util.Scanner;

public class WeirdAlgorithm {

    public void algo(long n) {
        StringBuilder sb = new StringBuilder();
        while (n != 1) {
            sb.append(n + " ");
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
        }
        sb.append(1);
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        WeirdAlgorithm wa = new WeirdAlgorithm();
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        wa.algo(n);
    }

}
