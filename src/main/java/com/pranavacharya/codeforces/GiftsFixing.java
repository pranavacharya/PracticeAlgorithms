package com.pranavacharya.codeforces;

import java.util.Scanner;

public class GiftsFixing {

    public long minMoves(int[] a, int[] b) {
        int n = a.length;
        long moves = 0;
        int amin = Integer.MAX_VALUE;
        int bmin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            amin = Math.min(amin, a[i]);
            bmin = Math.min(bmin, b[i]);
        }
        for (int i = 0; i < n; i++) {
            int rema = a[i] - amin;
            int remb = b[i] - bmin;
            int min = Math.min(rema, remb);
            moves += min;
            moves += Math.abs(rema - remb);
        }
        return moves;
    }

    public static void main(String args[]) {
        GiftsFixing gf = new GiftsFixing();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }
            sb.append(gf.minMoves(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
