package com.pranavacharya.codechef;

import java.util.Scanner;

public class TOTSCR {

    private long[] findTotalScr(int[] wt, String[] src) {
        long[] ans = new long[src.length];
        for (int i = 0; i < src.length; i++) {
            long local = 0;
            for (int j = 0; j < src[i].length(); j++) {
                if (src[i].charAt(j) == '1') {
                    local += wt[j];
                }
            }
            ans[i] = local;
        }
        return ans;
    }

    public static void main(String args[]) {
        TOTSCR tr = new TOTSCR();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] wt = new int[k];
            for (int j = 0; j < k; j++) {
                wt[j] = sc.nextInt();
            }
            String[] src = new String[n];
            for (int j = 0; j < n; j++) {
                src[j] = sc.next();
            }
            long[] ans = tr.findTotalScr(wt, src);
            for (int j = 0; j < ans.length; j++) {
                sb.append(ans[j]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
