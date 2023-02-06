/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pranavacharya.hiringtest;

/**
 *
 * @author pranav
 */
public class VaibhaviRhombus {

    private int solution(int[][] matrix, int radius) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        radius--;
        for (int i = radius; i < n - radius; i++) {
            for (int j = radius; j < m - radius; j++) {
                int local = perimeter(matrix, i, j, radius);
                if (local > max) {
                    max = local;
                }
            }
        }
        return max;
    }

    private int perimeter(int[][] grid, int x, int y, int radius) {
        int sum = 0;

        int row = x;
        int col = y - radius;

        while (row > x - radius && col < y) {
            sum += grid[row][col];
            row--;
            col++;
        }

        while (row < x && col < y + radius) {
            sum += grid[row][col];
            row++;
            col++;
        }

        while (row < x + radius && col > y) {
            sum += grid[row][col];
            row++;
            col--;
        }

        while (row > x && col > y - radius) {
            sum += grid[row][col];
            row--;
            col--;
        }
        return sum;
    }

    public static void main(String[] args) {
        VaibhaviRhombus vr = new VaibhaviRhombus();
        int[][] matrix = new int[][]{{10, 0, 4, 2, 7, 3}, {6, 2, 7, 2, 1, 1,}, {4, 1, 4, 5, 3, 0}, {3, 5, 2, 1, 4, 6}, {3, 4, 6, 1, 0, 4}, {3, 4, 6, 1, 0, 4}};
        System.out.println(vr.solution(matrix, 3));
    }
}
