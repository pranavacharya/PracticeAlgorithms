package com.pranavacharya.pepcoding;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumNonoverlappingBridges {

    private int findMaxNonOverlappingBriges(int[][] bridges) {
        int n = bridges.length;
        Arrays.sort(bridges, (a, b) -> (Double.compare(a[0], b[0])));
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((bridges[j][0] >= bridges[i][0] && bridges[j][1] >= bridges[i][1])
                        || (bridges[j][0] <= bridges[i][0] && bridges[j][1] <= bridges[i][1])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumNonoverlappingBridges mnob = new MaximumNonoverlappingBridges();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] bridges = new int[n][2];
        for (int i = 0; i < n; i++) {
            bridges[i][0] = sc.nextInt();
            bridges[i][1] = sc.nextInt();
        }
        System.out.println(mnob.findMaxNonOverlappingBriges(bridges));
    }
}
