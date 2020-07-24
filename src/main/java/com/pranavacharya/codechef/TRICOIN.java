package com.pranavacharya.codechef;

import java.util.Scanner;

public class TRICOIN {

    public int findHeight(int n) {
        int h = 0;
        int i = 0;
        while (h < n) {
            h = h + ++i;
            if (h > n) {
                i--;
                break;
            }
        }
        return i;
    }

    public static void main(String args[]) {
        TRICOIN cc = new TRICOIN();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            sb.append(cc.findHeight(n)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
