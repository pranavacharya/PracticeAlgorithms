package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class MAXDIFF {

    public long findMax(int[] w, int k) {
        Arrays.sort(w);
        int sum = 0;
        for (int i : w) {
            sum += i;
        }
        int batch1 = 0;
        for (int i = 0; i < k; i++) {
            batch1 += w[i];
        }
        int batch2 = 0;
        for (int i = w.length - 1; i > 0 && k > 0; i--, k--) {
            batch2 += w[i];
        }
        return Math.max(Math.abs(sum - batch1 - batch1), Math.abs(sum - batch2 - batch2));
    }

    public static void main(String args[]) {
        MAXDIFF md = new MAXDIFF();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] w = new int[n];
            int k = sc.nextInt();
            for (int j = 0; j < n; j++) {
                w[j] = sc.nextInt();
            }
            sb.append(md.findMax(w, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
