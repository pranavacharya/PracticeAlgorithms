package com.pranavacharya.codechef;

import java.util.Scanner;

public class SALARY {

    public int minMoves(int[] w) {
        int min = 0;
        int max = maxValue(w);
        while (!isSame(w)) {
            min += decrement(w, max);
            max = maxValue(w);
        }
        return min;
    }

    public int decrement(int[] w, int max) {
        int moves = 0;
        for (int i = 0; i < w.length; i++) {
            if (w[i] == max) {
                moves++;
                w[i]--;
            }
        }
        return moves;
    }

    public int maxValue(int[] w) {
        int max = -1;
        for (int i = 0; i < w.length; i++) {
            if (max < w[i]) {
                max = w[i];
            }
        }
        return max;
    }

    public boolean isSame(int[] w) {
        for (int i = 0; i < w.length - 1; i++) {
            if (w[i] != w[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        SALARY s = new SALARY();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] w = new int[n];
            for (int j = 0; j < n; j++) {
                w[j] = sc.nextInt();
            }
            sb.append(s.minMoves(w)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
