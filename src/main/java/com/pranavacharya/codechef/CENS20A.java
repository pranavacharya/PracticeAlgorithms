package com.pranavacharya.codechef;

import java.util.Scanner;

public class CENS20A {

    public void formMatrix(int[][] matrix, int[][] query) {
        for (int[] q : query) {
            int rows = q[0];
            int rowe = q[2];
            int cols = q[1];
            int cole = q[3];
            for (int i = rows; i <= rowe; i++) {
                for (int j = cols; j <= cole; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;;
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        CENS20A c = new CENS20A();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            int j = 1;
            for (char ch : line.toCharArray()) {
                matrix[i][j++] = ch == '0' ? 0 : 1;
            }
        }
        int q = sc.nextInt();
        int[][] query = new int[q][4];
        for (int i = 0; i < q; i++) {
            query[i][0] = sc.nextInt();
            query[i][1] = sc.nextInt();
            query[i][2] = sc.nextInt();
            query[i][3] = sc.nextInt();
        }
        c.formMatrix(matrix, query);
    }
}
