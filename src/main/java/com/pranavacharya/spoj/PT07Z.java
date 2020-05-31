package com.pranavacharya.spoj;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PT07Z {

    private int max;

    public PT07Z() {
        this.max = 0;
    }

    public int findLengthLongestPath(int nodes, ArrayList<Integer>[] adj, int[] inorder) {
        for (int i = 1; i <= nodes; i++) {
            if (inorder[i] == 0) {
                dfs(adj, i, new ArrayList());
                break;
            }
        }
        return this.max;
    }

    private int dfs(ArrayList<Integer>[] adj, int node, ArrayList<Integer> path) {
        if (adj[node].size() == 0) {
            return 0;
        } else {
            path.add(node);
            int d = 0;
            int local = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
            for (int n : adj[node]) {
                int value = dfs(adj, n, path) + 1;
                queue.add(value);
                local = Math.max(local, value);
            }
            d += queue.poll();
            if (!queue.isEmpty()) {
                d += queue.poll();
            }
            max = Math.max(max, d);
            path.remove(path.size() - 1);
            return local;
        }
    }

    public static void main(String args[]) {
        PT07Z p = new PT07Z();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        int[] inorder = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adj[i] = new ArrayList();
        }
        for (int i = 0; i < n - 1; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            adj[first].add(second);
            inorder[second]++;
        }
        System.out.println(p.findLengthLongestPath(n, adj, inorder));
    }
}
