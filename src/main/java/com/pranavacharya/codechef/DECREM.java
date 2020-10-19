package com.pranavacharya.codechef;

import java.util.Scanner;

public class DECREM {

    public int findN(int l, int r) {
        if (r < 2 * l) {
            return r;
        } else {
            return -1;
        }
    }

    public static void main(String args[]) {
        DECREM d = new DECREM();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            sb.append(d.findN(l, r)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
