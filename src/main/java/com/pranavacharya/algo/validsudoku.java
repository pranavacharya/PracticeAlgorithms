package com.pranavacharya.algo;

import java.util.HashSet;

public class validsudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet();
        HashSet<Character> column = new HashSet();
        HashSet<Character> grid = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!row.add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] != '.') {
                    if (!column.add(board[j][i])) {
                        return false;
                    }
                }
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !grid.add(board[RowIndex + j / 3][ColIndex + j % 3])) {
                    return false;
                }
            }
            row.clear();
            column.clear();
            grid.clear();
        }
        return true;
    }

    public static void main(String args[]) {
        char[][] board = {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
        };
        validsudoku vs = new validsudoku();
        System.out.println(vs.isValidSudoku(board));
    }
}
