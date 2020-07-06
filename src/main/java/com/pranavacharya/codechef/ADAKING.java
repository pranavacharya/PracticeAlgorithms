package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ADAKING {

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};

    public void bfs(char[][] board, int k) {
        Queue<int[]> bfs = new LinkedList();
        bfs.add(new int[]{4, 4});
        k--;
        board[4][4] = 'O';
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            for (int[] d : dir) {
                if (k > 0 && (curr[0] + d[0] >= 0 && curr[0] + d[0] < 8) && (curr[1] + d[1] >= 0 && curr[1] + d[1] < 8)
                        && board[(curr[0] + d[0])][(curr[1] + d[1])] != '.' && board[(curr[0] + d[0])][(curr[1] + d[1])] != 'O') {
                    bfs.add(new int[]{curr[0] + d[0], (curr[1] + d[1])});
                    board[(curr[0] + d[0])][(curr[1] + d[1])] = '.';
                    k--;
                }
            }
        }
    }

    public static void main(String args[]) {
        ADAKING a = new ADAKING();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int k = sc.nextInt();
            char[][] board = new char[8][8];
            for (char[] row : board) {
                Arrays.fill(row, 'B');
            }
            a.bfs(board, k);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == '.' || board[i][j] == 'O') {
                        continue;
                    }
                    boolean edge = false;
                    for (int[] d : dir) {
                        if ((i + d[0] >= 0 && i + d[0] < 8) && (j + d[1] >= 0 && j + d[1] < 8)) {
                            if (board[(i + d[0])][(j + d[1])] == '.' || board[(i + d[0])][(j + d[1])] == 'O') {
                                edge = true;
                                break;
                            }
                        }
                    }
                    if (edge) {
                        board[i][j] = 'X';
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (board[i][j] == 'B') {
                        board[i][j] = '.';
                    }
                }
            }
            for (char[] row : board) {
                for (char d : row) {
                    sb.append(d);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
