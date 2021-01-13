package com.pranavacharya.spoj;

import java.util.Arrays;
import java.util.Scanner;

public class LKS {

    public int findMaxWeight(int[][] val, int k) {
        int n = val.length;
        int[] dp = new int[k + 1];

        Arrays.fill(dp, 0);

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= val[i][1]; j--) {
                dp[j] = Math.max(dp[j], val[i][0] + dp[j - val[i][1]]);
            }
        }
        return dp[k];
    }

    public static void main(String args[]) {
        LKS l = new LKS();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] val = new int[n][2];
        for (int i = 0; i < n; i++) {
            val[i][0] = sc.nextInt();
            val[i][1] = sc.nextInt();
        }
        System.out.println(l.findMaxWeight(val, k));
    }
}
