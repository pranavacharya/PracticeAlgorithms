package com.pranavacharya.codechef;

import java.util.Scanner;

public class EVENPSUM {

    public long findPairs(long a, long b) {
        long aevens = 0;
        long aodds = 0;
        long bevens = 0;
        long bodds = 0;
        if (a % 2 == 0) {
            aevens += a / 2;
            aodds += a / 2;
        } else {
            aevens += ((a - 1) / 2);
            aodds += ((a - 1) / 2) + 1;
        }

        if (b % 2 == 0) {
            bevens += b / 2;
            bodds += b / 2;
        } else {
            bevens += ((b - 1) / 2);
            bodds += ((b - 1) / 2) + 1;
        }
        return aevens * bevens + aodds * bodds;
    }

    public static void main(String args[]) {
        EVENPSUM e = new EVENPSUM();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            sb.append(e.findPairs(a, b)).append('\n');
        }
        System.out.println(sb.toString());
    }
}
