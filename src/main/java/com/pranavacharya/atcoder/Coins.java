package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Coins {

    double[][] dp;

    private double findProbablity(double[] arr) {
        int n = arr.length;
        this.dp = new double[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(this.dp[i], -1.0);
        }
        return dfs(arr, n, (n + 1) / 2);
    }

    private double dfs(double[] arr, int i, int x) {
        // probablity of getting at least x head in i coins

        if (this.dp[i][x] != -1) {
            return this.dp[i][x];
        }
        if (x == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        double ans = dfs(arr, i - 1, x - 1) * arr[i - 1] + dfs(arr, i - 1, x) * (1 - arr[i - 1]);
        this.dp[i][x] = ans;
        return this.dp[i][x];
    }

    public static void main(String[] args) {
        Coins c = new Coins();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        System.out.println(c.findProbablity(arr));
    }
}
