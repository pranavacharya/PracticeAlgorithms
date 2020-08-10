package com.pranavacharya.codechef;

import java.util.Scanner;

public class CRDGAME3 {

    public int[] findWinnerAndMoves(int c, int r) {
        int cval = c / 9;
        int rval = r / 9;
        if (c % 9 != 0) {
            cval++;
        }
        if (r % 9 != 0) {
            rval++;
        }
        if (cval < rval) {
            return new int[]{0, cval};
        } else {
            return new int[]{1, rval};
        }
    }

    public static void main(String args[]) {
        CRDGAME3 c = new CRDGAME3();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int chef = sc.nextInt();
            int r = sc.nextInt();
            int[] ans = c.findWinnerAndMoves(chef, r);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
