package com.pranavacharya.codeforces;

import java.util.Scanner;

public class BoatsCompetition {

    public int maxPair(int n, int[] freq) {
        int max = 0;
        for (int s = 2; s <= 2 * n; s++) {
            int count = 0;
            for (int i = 1; i < (s + 1) / 2; i++) {
                if (s - i > n) {
                    continue;
                }
                count += Math.min(freq[i], freq[s - i]);
            }
            if (s % 2 == 0) {
                count += freq[s / 2] / 2;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String args[]) {
        BoatsCompetition bc = new BoatsCompetition();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[51];
            for (int j = 0; j < n; j++) {
                a[sc.nextInt()]++;
            }
            sb.append(bc.maxPair(n, a)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
