package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class CHEFWED {

    public int findMinInefficiency(int k, int[] f) {
        int[] dp = new int[f.length + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + k;
            HashMap<Integer, Integer> map = new HashMap();
            int arg = 0;
            for (int j = i; j > 0; j--) {
                map.put(f[j - 1], map.getOrDefault(f[j - 1], 0) + 1);
                if (map.get(f[j - 1]) == 2) {
                    arg += 2;
                } else if (map.get(f[j - 1]) > 2) {
                    arg++;
                }
                dp[i] = Math.min(dp[i], dp[j - 1] + k + arg);
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
