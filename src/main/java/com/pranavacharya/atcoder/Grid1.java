package com.pranavacharya.atcoder;

import java.util.Scanner;

public class Grid1 {

    private int mod = (int) 1e9 + 7;

    private long findWays(char[][] grid, int n, int m) {
        long[][] dp = new long[n][m];
        dp[0][0] = 1;
        for (int j = 1; j < m; j++) {
            if (grid[0][j] == '.') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == '.') {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] == '.') {
                    dp[i][j] = (dp[i - 1][j] % mod + dp[i][j - 1] % mod) % mod;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Grid1 g = new Grid1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        System.out.println(g.findWays(grid, n, m));
    }
}
