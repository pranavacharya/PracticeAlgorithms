package com.pranavacharya.codechef;

import java.util.Scanner;

public class EVENTUAL {

    public String isPossible(String ip) {
        int[] frequency = new int[26];
        for (char c : ip.toCharArray()) {
            frequency[c - 'a']++;
        }
        for (int i : frequency) {
            if (i % 2 != 0) {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String args[]) {
        EVENTUAL er = new EVENTUAL();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            String ip = sc.next();
            sb.append(er.isPossible(ip)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
