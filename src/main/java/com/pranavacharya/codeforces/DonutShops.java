package com.pranavacharya.codeforces;

import java.util.Scanner;

public class DonutShops {

    public long[] findMinDonut(long a, long b, long c) {
        long[] ans = new long[2];
        if (a < c) {
            ans[0] = 1;
        } else {
            ans[0] = -1;
        }

        if (a * b > c) {
            ans[1] = b;
        } else {
            ans[1] = -1;
        }
        return ans;
    }

    public static void main(String args[]) {
        DonutShops ds = new DonutShops();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long[] val = ds.findMinDonut(a, b, c);
            sb.append(val[0] + " " + val[1] + "\n");
        }
        System.out.println(sb.toString());
    }
}
