package com.pranavacharya.codeforces;

import java.util.Scanner;

public class BoardMoves {

    public long FindMoves(int n) {
        long moves = 0l;
        for (int i = 3, m = 1; i <= n; i += 2, m++) {
            long edges = 2 * i + 2 * (i - 2);
            long move = edges * m;
            moves += move;
        }
        return moves;
    }

    public static void main(String args[]) {
        BoardMoves bm = new BoardMoves();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 1; i <= testCase; i++) {
            int length = sc.nextInt();
            System.out.println(bm.FindMoves(length));
        }
    }
}
