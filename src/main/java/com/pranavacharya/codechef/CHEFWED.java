package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class CHEFWED {

    public int findMinInefficiency(int k, int[] f) {
        int[] dp = new int[f.length + 1];
        dp[0] = 0;
        dp[1] = k;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + k;
            for (int j = 0; j < i; j++) {
                HashMap<Integer, Integer> map = new HashMap();
                int arg = 0;
                for (int l = j + 1; l <= i; l++) {
                    map.put(f[l - 1], map.getOrDefault(f[l - 1], 0) + 1);
                }
                for (int val : map.values()) {
                    if (val > 1) {
                        arg += val;
                    }
                }
                dp[i] = Math.min(dp[i], dp[j] + k + arg);
            }
        }
        return dp[f.length];
    }

    public static void main(String args[]) {
        CHEFWED c = new CHEFWED();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(c.findMinInefficiency(k, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
