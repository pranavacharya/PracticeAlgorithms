package com.pranavacharya.kickstart;

import java.util.Scanner;

public class TransformTheString {

    private int findMinOps(String s, String f) {
        int[] f_list = new int[52];
        for (int i = 0; i < f.length(); i++) {
            int index = f.charAt(i) - 'a';
            f_list[index]++;
            f_list[index + 26]++;
        }
        int ops = 0;
        for (int i = 0; i < s.length(); i++) {
            int local1 = 0;
            int pos = s.charAt(i) - 'a';
            for (int j = pos; j < pos + 26; j++) {
                if (f_list[j] > 0) {
                    break;
                } else {
                    local1++;
                }
            }
            int local2 = 0;
            for (int j = pos + 26; j > pos; j--) {
                if (f_list[j] > 0) {
                    break;
                } else {
                    local2++;
                }
            }
            ops += Math.min(local1, local2);
        }
        return ops;
    }

    public static void main(String[] args) {
        TransformTheString ts = new TransformTheString();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = sc.next();
            String f = sc.next();
            sb.append("Case #").append(i).append(": ").append(ts.findMinOps(s, f)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
