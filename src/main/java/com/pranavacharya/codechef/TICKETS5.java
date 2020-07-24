package com.pranavacharya.codechef;

import java.util.Scanner;

public class TICKETS5 {

    public String isLucky(String ip) {
        if (ip.length() % 2 != 0) {
            return "NO";
        }
        char a = ip.charAt(0);
        char b = ip.charAt(1);
        if (a == b) {
            return "NO";
        }
        for (char i = 0; i < ip.length(); i++) {
            if (i % 2 == 0 && ip.charAt(i) == a) {
                continue;
            } else if (i % 2 != 0 && ip.charAt(i) == b) {
                continue;
            }
            return "NO";
        }
        return "YES";
    }

    public static void main(String args[]) {
        TICKETS5 tvt = new TICKETS5();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String ip = sc.next();
            sb.append(tvt.isLucky(ip)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
