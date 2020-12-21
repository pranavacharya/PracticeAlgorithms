package com.pranavacharya.codechef;

import java.util.Scanner;

public class CATHIEF {

    public String canCatch(int x, int y, int k, int n) {
        int dist = Math.abs(x - y);
        if (dist % k == 0) {
            if ((dist / k) % 2 == 0) {
                return "Yes";
            } else {
                return "No";
            }
        } else {
            return "No";
        }
    }

    public static void main(String args[]) {
        CATHIEF c = new CATHIEF();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            int n = sc.nextInt();
            sb.append(c.canCatch(x, y, k, n)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
