package com.pranavacharya.atcoder;

import java.util.Scanner;

public class CHandV {

    public int findChoices(char[][] grid, int k) {
        int ans = 0;
        for (int mask = 0; mask < 1 << (grid.length + grid[0].length); mask++) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != '#') {
                        continue;
                    }
                    if ((mask & (1 << i)) != 0 || (mask & (1 << (grid.length + j))) != 0) {
                        continue;
                    }
                    count++;
                }
            }
            if (count == k) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        CHandV chv = new CHandV();
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        char[][] grid = new char[h][w];
        for (int i = 0; i < grid.length; i++) {
            String row = sc.next();
            for (int j = 0; j < row.length(); j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        System.out.println(chv.findChoices(grid, k));
    }
}
