package com.pranavacharya.spoj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PT07Z {

    private int[] visited;
    private int maxD;
    private int maxNode;

    public int findLengthLongestPath(int nodes, ArrayList<Integer>[] adj) {
        maxD = -1;
        maxNode = -1;
        visited = new int[nodes + 1];
        dfs(adj, visited, 1, 0);

        Arrays.fill(visited, 0);
        maxD = -1;
        dfs(adj, visited, maxNode, 0);

        return maxD;
    }

    private void dfs(ArrayList<Integer>[] adj, int[] visited, int node, int depth) {
        visited[node] = 1;
        if (depth > maxD) {
            maxD = depth;
            maxNode = node;
        }
        for (int nei : adj[node]) {
            if (visited[nei] == 0) {
                dfs(adj, visited, nei, depth + 1);
            }
        }
    }

    public static void main(String args[]) {
        PT07Z p = new PT07Z();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < n - 1; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            adj[first].add(second);
            adj[second].add(first);
        }
        System.out.println(p.findLengthLongestPath(n, adj));
    }
}
