package com.pranavacharya.codechef;

import java.util.Scanner;

public class SPLITIT {

    public String isPossible(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.substring(0, i).contains(input.substring(i))) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        SPLITIT s = new SPLITIT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            String str = sc.next();
            sb.append(s.isPossible(str)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
