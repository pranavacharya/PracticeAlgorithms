package com.pranavacharya.codechef;

import java.util.Scanner;

public class CVDRUN {

    public boolean canReach(int n, int k, int x, int y) {
        if (x == y) {
            return true;
        }
        int c = x;
        do {
            c = c + k;
            c = c % n;
        } while (c != x && c != y);
        if (c == x) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {
        CVDRUN c = new CVDRUN();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (c.canReach(n, k, x, y)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
