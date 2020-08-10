package com.pranavacharya.codechef;

import java.util.Scanner;

public class LINCHESS {

    public int bestPlayer(int[] p, int k) {
        int min = Integer.MAX_VALUE;
        int val = -1;
        for (int i : p) {
            if (k % i == 0) {
                if ((k / i) < min) {
                    val = i;
                    min = k / i;
                }
            }
        }
        return val;
    }

    public static void main(String args[]) {
        LINCHESS l = new LINCHESS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] p = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = sc.nextInt();
            }
            sb.append(l.bestPlayer(p, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
