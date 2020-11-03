package com.pranavacharya.codechef;

import java.util.Scanner;

public class ANDOR {

    public String getPair(long x) {
        return "" + x + " " + 0;
    }

    public static void main(String args[]) {
        ANDOR a = new ANDOR();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            sb.append(a.getPair(x)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
