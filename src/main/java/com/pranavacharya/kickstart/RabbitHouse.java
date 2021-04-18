package com.pranavacharya.kickstart;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RabbitHouse {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private long minBoxes(int[][] grid) {
        long minBoxes = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (grid[b[0]][b[1]] - grid[a[0]][a[1]]));
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                queue.add(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int height = grid[x][y];
            for (int[] dir : dirs) {
                if (x + dir[0] >= 0 && x + dir[0] < grid.length
                        && y + dir[1] >= 0 && y + dir[1] < grid[x].length
                        && grid[x + dir[0]][y + dir[1]] < height - 1) {
                    int diff = (height - 1 - grid[x + dir[0]][y + dir[1]]);
                    minBoxes += diff;
                    grid[x + dir[0]][y + dir[1]] += diff;
                    queue.add(new int[]{x + dir[0], y + dir[1]});
                }
            }
        }

        return minBoxes;
    }

    public static void main(String[] args) {
        RabbitHouse rh = new RabbitHouse();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int[][] arr = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            long count = rh.minBoxes(arr);
            sb.append("Case #").append(i).append(": ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
