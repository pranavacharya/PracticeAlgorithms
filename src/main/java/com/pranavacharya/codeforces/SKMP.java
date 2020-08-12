package com.pranavacharya.codeforces;

import java.util.Scanner;

public class SKMP {

    public String findSmallestAnagram(String S, String P) {
        int[] frequency = new int[26];
        for (char c : S.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (char c : P.toCharArray()) {
            frequency[c - 'a']--;
        }
        char start = P.charAt(0);
        int index = 0;
        while (P.charAt(index) == start) {
            index++;
        }
        if (P.charAt(index) > start) {
            start++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start - 'a'; i++) {
            int freq = frequency[i];
            for (int j = 0; j < freq; j++) {
                sb.append((char) ('a' + i));
            }
        }
        sb.append(P);
        for (int i = start - 'a'; i < 26; i++) {
            int freq = frequency[i];
            for (int j = 0; j < freq; j++) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        SKMP s = new SKMP();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String S = sc.next();
            String P = sc.next();
            sb.append(s.findSmallestAnagram(S, P)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
