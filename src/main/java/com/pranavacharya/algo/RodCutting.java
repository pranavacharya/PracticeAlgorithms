package com.pranavacharya.algo;

import java.util.Arrays;

public class RodCutting {

    int[][] memo;

    private int findMaxCost(int[] prices) {
        this.memo = new int[prices.length + 1][prices.length + 1];
        for (int i = 0; i < this.memo.length; i++) {
            Arrays.fill(this.memo[i], -1);
        }
        int ans = helper(prices, 0, prices.length);
        System.out.println(Arrays.deepToString(this.memo));
        return ans;
    }

    private int helper(int[] prices, int i, int j) {

        if (this.memo[i][j] != -1) {
            return this.memo[i][j];
        }

        if (i >= j) {
            return this.memo[i][j] = 0;
        }

        int max = prices[j - i - 1];
        for (int k = i + 1; k < j; k++) {
            max = Math.max(Math.max(prices[k - i - 1] + helper(prices, k, j), prices[j - k - 1] + helper(prices, i, k)), max);
        }
        return this.memo[i][j] = max;
    }

    public static void main(String[] args) {
        RodCutting rc = new RodCutting();
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(rc.findMaxCost(prices));
    }
}
