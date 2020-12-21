package com.pranavacharya.codechef;

import java.util.Scanner;

public class SDSTRING {

    public int findMinOps(String s) {
        if (s.length() % 2 == 1) {
            return -1;
        }
        int ones = 0;
        int zeroes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeroes++;
            }
        }
        if (ones == zeroes) {
            return 0;
        }
        int diff = Math.abs(ones - zeroes);

        if (ones == 0 || zeroes == 0) {
            return -1;
        }
        return diff / 2;
    }

    public static void main(String args[]) {
        SDSTRING sd = new SDSTRING();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            sb.append(sd.findMinOps(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
