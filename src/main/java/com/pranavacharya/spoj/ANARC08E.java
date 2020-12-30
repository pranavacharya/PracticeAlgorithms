package com.pranavacharya.spoj;

import java.util.Scanner;

public class ANARC08E {

    private int findPossibility(int a, int b) {
        int[][] dp = new int[a + 1][b + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[a][b];
    }

    public static void main(String args[]) {
        ANARC08E an = new ANARC08E();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1) {
                break;
            }
            int pos = an.findPossibility(a, b);
            if (pos == a + b) {
                sb.append(a).append("+").append(b).append("=").append(a + b).append("\n");
            } else {
                sb.append(a).append("+").append(b).append("!=").append(a + b).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
