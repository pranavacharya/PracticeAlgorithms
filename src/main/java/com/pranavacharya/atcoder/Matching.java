package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Matching {

    private int mod = (int) 1e9 + 7;
    private int[][] dp;

    private int findMatchingWays(int[][] compact, int n) {
        this.dp = new int[n + 1][1 << 22];
        for (int i = 0; i < this.dp.length; i++) {
            Arrays.fill(this.dp[i], -1);
        }
        return helper(compact, n, 1, (1 << n) - 1);
    }

    private int helper(int[][] compact, int n, int i, int mask) {
        if (i == n + 1) {
            if (mask == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (this.dp[i][mask] != -1) {
            return this.dp[i][mask];
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            boolean available = ((1 << j) & mask) != 0;
            if (available && compact[i][j + 1] == 1) {
                ans = (ans % mod + helper(compact, n, i + 1, mask ^ (1 << j)) % mod) % mod;
            }
        }
        return this.dp[i][mask] = ans;
    }

    public static void main(String[] args) {
        Matching m = new Matching();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] compact = new int[n + 1][n + 1];
        for (int i = 1; i < compact.length; i++) {
            for (int j = 1; j < compact[i].length; j++) {
                compact[i][j] = sc.nextInt();
            }
        }
        System.out.println(m.findMatchingWays(compact, n));
    }
}
