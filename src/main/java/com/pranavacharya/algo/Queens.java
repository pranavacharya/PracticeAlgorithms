package com.pranavacharya.algo;

import java.util.HashSet;
import java.util.Scanner;

public class Queens {

    public static boolean isValidConf(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> column = new HashSet<>();
        HashSet<Character> diagonal1 = new HashSet<>();
        HashSet<Character> diagonal2 = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '1') {
                    if (!row.add(board[i][j])) {
                        return false;
                    }
                }
                if (board[j][i] == '1') {
                    if (!column.add(board[j][i])) {
                        return false;
                    }
                }
                if (board[i][j] == '1') {
                    for (int k = 0; k < board.length; k++) {
                        for (int l = 0; l < board.length; l++) {
                            if (board[k][l] == '1' && k + l == i + j) {
                                if (!diagonal1.add(board[i][j])) {
                                    return false;
                                }
                            }
                            if (board[k][l] == '1' && k - l == i - j) {
                                if (!diagonal2.add(board[i][j])) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                diagonal1.clear();
                diagonal2.clear();
            }
            row.clear();
            column.clear();
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int order;
        while (true) {
            order = sc.nextInt();
            sc.nextLine();
            char[][] board = new char[order][order];
            for (int i = 0; i < order; i++) {
                String row = sc.nextLine();
                board[i] = row.toCharArray();
            }
            for (int i = 0; i < order; i++) {
                for (int j = 0; j < order; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(isValidConf(board));
        }
    }
}
