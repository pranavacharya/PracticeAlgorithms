package com.pranavacharya.codegladiators;

import java.util.Scanner;

public class ThePowerpuffGirls {

    public void maxPPG(long[] req, long[] available) {
        long count = Long.MAX_VALUE;
        for (int i = 0; i < available.length; i++) {
            if (req[i] != 0) {
                long used = available[i] / req[i];
                count = Math.min(count, used);
            }
        }
        if (count != Long.MAX_VALUE) {
            System.out.println(count);
        } else {
            System.out.println(0);
        }
    }

    public static void main(String args[]) {
        ThePowerpuffGirls tppg = new ThePowerpuffGirls();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] req = new long[N];
        long[] available = new long[N];
        for (int i = 0; i < N; i++) {
            req[i] = sc.nextLong();
        }
        for (int i = 0; i < N; i++) {
            available[i] = sc.nextLong();
        }
        tppg.maxPPG(req, available);
    }
}
