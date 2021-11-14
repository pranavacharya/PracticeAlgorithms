package com.pranavacharya.kickstart;

import java.util.Scanner;

public class Painter {

    private int findMinOps(String s) {
        int ops = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            char c = s.charAt(i);
            sb.append(c);
            i = j;
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'B') {
                ops++;
            } else if (sb.charAt(i) == 'Y') {
                ops++;
            } else {
                if (i > 0 && i < sb.length() - 1) {
                    if (sb.charAt(i - 1) == sb.charAt(i + 1)) {
                    }
                } else {
                    if (i == 0 && i == sb.length() - 1) {
                        ops++;
                    }
                    ops++;
                }
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        Painter p = new Painter();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int length = sc.nextInt();
            String s = sc.next();
            sb.append("Case #").append(i).append(": ").append(p.findMinOps(s)).append("\n");
        }
        System.out.println(sb.toString());
    }

}
