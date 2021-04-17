package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class Sushi {

    double[][][] dp = new double[302][302][302];

    private double findExpectation(int[] arr) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                one++;
            } else if (arr[i] == 2) {
                two++;
            } else {
                three++;
            }
        }
        return dfs(one, two, three, arr.length);
    }

    private double dfs(int x, int y, int z, int n) {
        if (x < 0 || y < 0 || z < 0) {
            return 0;
        }

        if (x == 0 && y == 0 && z == 0) {
            return 0;
        }

        if (this.dp[x][y][z] != -1.0) {
            return this.dp[x][y][z];
        }

        double exp = n + x * dfs(x - 1, y, z, n) + y * dfs(x + 1, y - 1, z, n) + z * dfs(x, y + 1, z - 1, n);

        this.dp[x][y][z] = (exp / (x + y + z));

        return this.dp[x][y][z];
    }

    public static void main(String[] args) {
        Sushi s = new Sushi();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(s.findExpectation(arr));
    }
}
