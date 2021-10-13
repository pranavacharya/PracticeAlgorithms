package com.pranavacharya.hackerrank;

import java.util.Arrays;

public class FileRenaming {

    public static int renameFile(String newName, String oldName) {
        // Write your code here
        int n = newName.length();
        int m = oldName.length();
        int[][] dp = new int[n + 1][m + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (newName.charAt(i) == oldName.charAt(j)) {
                    dp[i + 1][j + 1] = (dp[i][j] % mod + dp[i + 1][j] % mod) % mod;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
