package com.pranavacharya.algo;

import java.util.HashSet;
import java.util.Scanner;

public class Queens {

    public static boolean isValidConf(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> column = new HashSet<>();
        HashSet<Character> diagonal = new HashSet<>();
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