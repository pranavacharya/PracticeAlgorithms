package com.pranavacharya.atcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class LongestPath {

    private int[] memo;

    private int findLongestPathLength(int n, HashMap<Integer, ArrayList<Integer>> adj) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, - 1);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dfs(i, adj));
        }
        return max;
    }

    private int dfs(int node, HashMap<Integer, ArrayList<Integer>> adj) {
        if (this.memo[node] != -1) {
            return this.memo[node];
        }
        ArrayList<Integer> neighbours = adj.get(node);
        int length = 0;
        for (int i = 0; i < neighbours.size(); i++) {
            length = Math.max(length, 1 + dfs(neighbours.get(i), adj));
        }
        this.memo[node] = length;
        return this.memo[node];
    }

    public static void main(String args[]) {
        LongestPath lp = new LongestPath();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int i = 0; i < m; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            adj.get(first).add(second);
        }
        System.out.println(lp.findLongestPathLength(n, adj));
    }
}
