package com.pranavacharya.cses;

import java.util.Scanner;

public class DiceCombinations {

    private int mod = (int) (1e9 + 7);

    private int findNumberOfCombination(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6 && i - j >= 0; j++) {
                dp[i] = (dp[i] % mod + dp[i - j] % mod) % mod;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DiceCombinations dc = new DiceCombinations();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(dc.findNumberOfCombination(n));
    }
}
