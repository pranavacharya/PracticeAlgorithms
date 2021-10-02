package com.pranavacharya.kickstart;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Festival {

    private long maxHappy(int d, int k, int[][] arr) {
        long max = 0;
        ArrayList<Integer>[] start = new ArrayList[d + 2];
        ArrayList<Integer>[] end = new ArrayList[d + 2];
        for (int i = 0; i < start.length; i++) {
            start[i] = new ArrayList();
            end[i] = new ArrayList();
        }
        for (int i = 0; i < arr.length; i++) {
            start[arr[i][1]].add(i);
            end[arr[i][2] + 1].add(i);
        }
        // min heap -> set
        TreeSet<int[]> top = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // max heap -> set
        TreeSet<int[]> available = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        long runningSum = 0;
        for (int i = 1; i <= d; i++) {

            // adding event
            for (int j = 0; j < start[i].size(); j++) {
                int index = start[i].get(j);
                available.add(new int[]{arr[index][0], index});
            }

            // removing event
            for (int j = 0; j < end[i].size(); j++) {
                int index = end[i].get(j);
                available.remove(new int[]{arr[index][0], index});

                boolean isPresent = top.remove(new int[]{arr[index][0], index});
                if (isPresent) {
                    runningSum -= arr[index][0];
                }
            }

            // maintaining k elements in top if available
            while (top.size() < k && !available.isEmpty()) {
                int[] currMax = available.first();
                top.add(currMax);
                runningSum += currMax[0];

                available.remove(currMax);
            }

            // balancing the heap -> set
            while (!top.isEmpty() && !available.isEmpty() && top.first()[0] < available.first()[0]) {
                int[] currMax = available.first();
                top.add(currMax);
                runningSum += currMax[0];

                available.remove(currMax);

                int[] topMin = top.first();
                top.remove(topMin);
                runningSum -= topMin[0];

                available.add(topMin);
            }

            max = Math.max(max, runningSum);
        }
        return max;
    }

    public static void main(String[] args) {
        Festival f = new Festival();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int d = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int j = 0; j < n; j++) {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                arr[j][2] = sc.nextInt();
            }
            sb.append("Case #" + (i + 1) + ": " + f.maxHappy(d, k, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
