package com.pranavacharya.codeforces;

import java.util.Scanner;

public class BeautifulMatrix {

    private int minMoves(int[][] mat) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (mat[i][j] == 1) {
                    return Math.abs(i - 2) + Math.abs(j - 2);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BeautifulMatrix bm = new BeautifulMatrix();
        Scanner sc = new Scanner(System.in);
        int[][] mat = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(bm.minMoves(mat));
    }
}
