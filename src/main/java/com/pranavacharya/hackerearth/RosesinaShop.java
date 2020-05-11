package com.pranavacharya.hackerearth;

import java.util.Scanner;

public class RosesinaShop {

    public int maxSubArrayLength(int[] smell) {
        if (smell == null || smell.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] pre = new int[smell.length];
        int[] suf = new int[smell.length];
        pre[0] = 1;
        for (int i = 1; i < pre.length; i++) {
            if (smell[i] > smell[i - 1]) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 1;
            }
            ans = Math.max(ans, pre[i]);
        }
        suf[suf.length - 1] = 1;
        for (int i = suf.length - 2; i >= 0; i--) {
            if (smell[i] < smell[i + 1]) {
                suf[i] = suf[i + 1] + 1;
            } else {
                suf[i] = 1;
            }
            ans = Math.max(ans, suf[i]);
        }
        for (int i = 1; i < smell.length - 1; i++) {
            if (smell[i - 1] < smell[i + 1]) {
                ans = Math.max(ans, pre[i - 1] + suf[i + 1]);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        RosesinaShop rs = new RosesinaShop();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] smell = new int[n];
        for (int i = 0; i < n; i++) {
            smell[i] = sc.nextInt();
        }
        System.out.println(rs.maxSubArrayLength(smell));
    }

}
