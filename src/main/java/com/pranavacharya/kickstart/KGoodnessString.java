package com.pranavacharya.kickstart;

import java.util.Scanner;

public class KGoodnessString {

    private int findMinOps(String s, int k) {
        int goodness = findGoodness(s);
        return Math.abs(k - goodness);
    }

    private int findGoodness(String s) {
        int count = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        KGoodnessString cs = new KGoodnessString();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int min = cs.findMinOps(s, k);
            sb.append("Case #").append(i).append(": ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
}
