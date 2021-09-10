/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pranavacharya.hackerrank;

import java.util.Scanner;

/**
 *
 * @author pranav
 */
public class WordPuzzles {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private int[][] find(char[][] grid, String[] words) {
        int[][] ans = new int[words.length][2];
        for (int x = 0; x < words.length; x++) {
            outer:
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == words[x].charAt(0)) {
                        if (dfs(grid, words[x], 1, i, j, -1)) {
                            ans[x] = new int[]{i + 1, j + 1};
                            break outer;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] grid, String word, int index, int row, int col, int direction) {
        if (index == word.length()) {
            return true;
        }
        char temp = grid[row][col];
        grid[row][col] = '#';
        if (direction == -1) {
            int dirIndex = 0;
            for (int dir[] : dirs) {
                int x = dir[0] + row;
                int y = dir[1] + col;
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == word.charAt(index)) {
                    if (dfs(grid, word, index + 1, x, y, dirIndex)) {
                        grid[row][col] = temp;
                        return true;
                    }
                }
                dirIndex++;
            }
        } else {
            int x = dirs[direction][0] + row;
            int y = dirs[direction][1] + col;
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == word.charAt(index)) {
                if (dfs(grid, word, index + 1, x, y, direction)) {
                    grid[row][col] = temp;
                    return true;
                }
            }
        }
        grid[row][col] = temp;
        return false;
    }

    public static void main(String[] args) {
        WordPuzzles wp = new WordPuzzles();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] grid = new char[n][m];
            for (int j = 0; j < n; j++) {
                String temp = sc.next();
                temp = temp.toLowerCase();
                grid[j] = temp.toCharArray();
            }
            int numberOfWords = sc.nextInt();
            String[] words = new String[numberOfWords];
            for (int j = 0; j < numberOfWords; j++) {
                String temp = sc.next();
                temp = temp.toLowerCase();
                words[j] = temp;
            }
            int[][] ans = wp.find(grid, words);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < ans.length; j++) {
                sb.append(ans[j][0]).append(" ").append(ans[j][1]).append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}
