package com.pranavacharya.hiringtest;

public class DividingForest {

    private int findWays(int[][] grid, int p) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[i] = rows[i] | grid[i][j] == 2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[i] = cols[i] | grid[j][i] == 2;
            }
        }

        int[] r = new int[n];
        for (int i = 1; i < n; i++) {
            r[i] += r[i - 1];
            r[i] += rows[i] ? 1 : 0;
        }
        int[] c = new int[m];
        for (int i = 1; i < m; i++) {
            c[i] += c[i - 1];
            c[i] += cols[i] ? 1 : 0;
        }

        return helper(grid, 0, 0, p, rows, cols);
    }

    private int helper(int[][] grid, int i, int j, int n, boolean[] rows, boolean[] cols) {

        if (n == 0) {
            return 1;
        }

        int ans = 0;
        for (int k = i; k < grid.length; k++) {
            if (rows[rows.length - 1] == rows[k]) {
                break;
            }
            ans += helper(grid, k, j, n - 1, rows, cols);
        }

        for (int k = 0; k < grid[0].length; k++) {
            if (cols[cols.length - 1] == cols[k]) {
                break;
            }
            ans += helper(grid, i, k, n - 1, rows, cols);
        }

        return ans;
    }

    public static void main(String[] args) {
        DividingForest df = new DividingForest();
        int[][] grid = new int[][]{{1, 2, 3}, {2, 1, 2}, {3, 1, 1}};
        System.out.println(df.findWays(grid, 3));
    }
}
