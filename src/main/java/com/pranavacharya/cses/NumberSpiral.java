package com.pranavacharya.cses;

import java.util.Scanner;

public class NumberSpiral {

    public static void main(String args[]) {
        NumberSpiral ns = new NumberSpiral();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            if (x > y) {
                if (x % 2 == 0) {
                    sb.append((x * x) - (y - 1) + "\n");
                } else {
                    sb.append(((x - 1) * (x - 1)) + 1 + (y - 1) + "\n");
                }
            } else {
                if (y % 2 == 0) {
                    sb.append((y - 1) * (y - 1) + 1 + (x - 1) + "\n");
                } else {
                    sb.append((y * y) - (x - 1) + "\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
