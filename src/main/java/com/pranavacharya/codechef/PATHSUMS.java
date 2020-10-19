package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PATHSUMS {

    public int[] assignValue(HashMap<Integer, ArrayList<Integer>> adj, int n) {
        int[] colors = new int[n];
        boolean[] visited = new boolean[n];
        dfs(adj, colors, visited, 1, 0);
        return colors;
    }

    private void dfs(HashMap<Integer, ArrayList<Integer>> adj, int[] colors, boolean[] visited, int color, int current) {
        if (!visited[current]) {
            colors[current] = color;
            visited[current] = true;
            ArrayList<Integer> neighbours = adj.get(current);
            for (int neighbour : neighbours) {
                if (color == 1) {
                    color = 2;
                } else {
                    color = 1;
                }
                dfs(adj, colors, visited, color, neighbour);
                if (color == 1) {
                    color = 2;
                } else {
                    color = 1;
                }
            }
        }
    }

    public static void main(String args[]) {
        PATHSUMS p = new PATHSUMS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
            for (int j = 0; j < n; j++) {
                adj.put(j, new ArrayList());
            }
            for (int j = 0; j < n - 1; j++) {
                int first = sc.nextInt();
                int last = sc.nextInt();
                adj.get(first - 1).add(last - 1);
                adj.get(last - 1).add(first - 1);
            }
            int[] arr = p.assignValue(adj, n);
            for (int j = 0; j < n; j++) {
                sb.append(arr[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
