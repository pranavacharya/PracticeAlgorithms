package com.pranavacharya.kickstart;

import java.util.Scanner;

public class LShappedPlots {

    private long count;

    private long countPlots(int[][] grid) {
        this.count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dfs(grid, i, j, 1, 1, 1, 1);
                dfs(grid, i, j, 1, 1, 1, -1);
                dfs(grid, i, j, 1, 1, -1, 1);
                dfs(grid, i, j, 1, 1, -1, -1);
            }
        }
        return this.count;
    }

    private void dfs(int[][] grid, int row, int col, int vh, int hh,
            int vdir, int hdir) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length
                || grid[row][col] != 1) {
            return;
        }

        if (vh > 1 && hh > 1 && (vh == 2 * hh || 2 * vh == hh)) {
            this.count++;
        }

        if (vh > 1) {
            dfs(grid, row, col + hdir, vh, hh + 1, vdir, hdir);
        }

        if (hh == 1) {
            dfs(grid, row + vdir, col, vh + 1, hh, vdir, hdir);
        }
    }

    public static void main(String[] args) {
        LShappedPlots lsp = new LShappedPlots();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            long count = lsp.countPlots(arr);
            sb.append("Case #").append(i).append(": ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
