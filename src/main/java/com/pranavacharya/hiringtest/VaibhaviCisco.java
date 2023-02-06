package com.pranavacharya.hiringtest;

public class VaibhaviCisco {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public String funcPuzzle(char[][] grid, String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String w : word) {
            boolean flag = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (dfs(grid, w, 0, i, j)) {
                        sb.append("Yes").append(" ");
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                sb.append("No").append(" ");
            }
        }
        return sb.toString().trim();
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {

        char c = board[i][j];

        if (word.charAt(index) != c) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        board[i][j] = '#';

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < board.length && y >= 0 && y < board[x].length) {
                if (dfs(board, word, index + 1, x, y)) {
                    board[i][j] = c;
                    return true;
                }
            }
        }

        board[i][j] = c;
        return false;
    }

    public static void main(String[] args) {
        VaibhaviCisco vc = new VaibhaviCisco();
//        char[][] grid = new char[][]{{'C', 'A', 'T'}, {'I', 'D', 'O'}, {'N', 'O', 'M'}};
//        String[] words = new String[]{"CAT", "TOM", "ADO", "MOM"};
        char[][] grid = new char[][]{{'A', 'B', 'C'}, {'T', 'A', 'C'}, {'N', 'U', 'S'}, {'T', 'U', 'H'}};
        String[] words = new String[]{"HUT", "CAT", "SUN"};
        System.out.println(vc.funcPuzzle(grid, words));
    }
}
