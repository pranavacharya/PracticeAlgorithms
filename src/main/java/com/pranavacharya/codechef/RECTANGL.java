package com.pranavacharya.codechef;

import java.util.Scanner;

public class RECTANGL {

    public String isRect(int a, int b, int c, int d) {
        int ans = a ^ b ^ c ^ d;
        if (ans > 0) {
            return "NO";
        }
        return "YES";
    }

    public static void main(String args[]) {
        RECTANGL r = new RECTANGL();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            sb.append(r.isRect(a, b, c, d)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
