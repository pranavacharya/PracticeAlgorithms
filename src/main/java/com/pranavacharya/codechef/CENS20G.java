package com.pranavacharya.codechef;

import java.util.Scanner;

public class CENS20G {

    public String isPossible(String S, int x, int y, int[][] q) {
        long countR = 0;
        long countL = 0;
        long countU = 0;
        long countD = 0;
        char[] arr = S.toCharArray();
        for (char c : arr) {
            switch (c) {
                case 'R':
                    countR++;
                    break;
                case 'L':
                    countL++;
                    break;
                case 'U':
                    countU++;
                    break;
                default:
                    countD++;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] query : q) {
            long dx = query[0] - x;
            long dy = query[1] - y;
            long ops = Math.abs(dx) + Math.abs(dy);
            if (ops == 0) {
                sb.append("YES 0").append("\n");
                continue;
            }
            boolean statusX, statusY;
            if (dy > 0) {
                statusY = Math.abs(dy) <= countU;
            } else {
                statusY = Math.abs(dy) <= countD;
            }
            if (dx > 0) {
                statusX = Math.abs(dx) <= countR;
            } else {
                statusX = Math.abs(dx) <= countL;
            }
            if (statusX && statusY) {
                sb.append("YES ").append(ops).append("\n");
            } else {
                sb.append("NO \n");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String args[]) {
        CENS20G c = new CENS20G();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String S = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int g = sc.nextInt();
            int[][] q = new int[g][2];
            for (int j = 0; j < g; j++) {
                int x1 = sc.nextInt();
                int y1 = sc.nextInt();
                q[j][0] = x1;
                q[j][1] = y1;
            }
            sb.append(c.isPossible(S, x, y, q)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
