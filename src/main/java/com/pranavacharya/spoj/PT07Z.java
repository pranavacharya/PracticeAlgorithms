package com.pranavacharya.spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class PT07Z {

    private int max;

    public PT07Z() {
        this.max = 0;
    }

    public int findLengthLongestPath(int nodes, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        int[] inorder = new int[nodes + 1];
        for (int[] e : edges) {
            ArrayList<Integer> temp = adj.getOrDefault(e[0], new ArrayList());
            temp.add(e[1]);
            adj.put(e[0], temp);
            inorder[e[1]]++;
        }
        for (int i = 1; i <= nodes; i++) {
            if (inorder[i] == 0) {
                dfs(adj, i, new ArrayList());
            }
        }
        return this.max;
    }

    private int dfs(HashMap<Integer, ArrayList<Integer>> adj, int node, ArrayList<Integer> path) {
        if (!adj.containsKey(node)) {
            return 0;
        } else {
            path.add(node);
            ArrayList<Integer> neighbour = adj.get(node);
            int d = 0;
            int local = 0;
            ArrayList<Integer> l = new ArrayList();
            for (int n : neighbour) {
                int value = dfs(adj, n, path) + 1;
                l.add(value);
                local = Math.max(local, value);
            }
            Collections.sort(l);
            d += l.get(l.size() - 1);
            if (l.size() > 1) {
                d += l.get(l.size() - 2);
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
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.println(p.findLengthLongestPath(n, edges));
    }
}
