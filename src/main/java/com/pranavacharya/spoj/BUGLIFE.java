package com.pranavacharya.spoj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BUGLIFE {

    public void findSuspiciousBug(int numBugs, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap();
        for (int[] e : edges) {
            ArrayList<Integer> first = adj.getOrDefault(e[0], new ArrayList());
            first.add(e[1]);
            adj.put(e[0], first);
            ArrayList<Integer> second = adj.getOrDefault(e[1], new ArrayList());
            second.add(e[0]);
            adj.put(e[1], second);
        }
        int[] color = new int[numBugs + 1];
        for (int i = 1; i < color.length; i++) {
            if (color[i] == 0 && !dfs(adj, color, 1, i)) {
                System.out.println("Suspicious bugs found!");
                return;
            }
        }
        System.out.println("No suspicious bugs found!");
    }

    private boolean dfs(HashMap<Integer, ArrayList<Integer>> adj, int[] color, int currentColour, int node) {
        if (color[node] != 0) {
            return currentColour == color[node];
        } else {
            color[node] = currentColour;
            ArrayList<Integer> nei = adj.getOrDefault(node, new ArrayList());
            for (int n : nei) {
                if (!dfs(adj, color, -currentColour, n)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String args[]) {
        BUGLIFE b = new BUGLIFE();
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 1; i <= testcase; i++) {
            int noBug = sc.nextInt();
            int interactions = sc.nextInt();
            int[][] edges = new int[interactions][2];
            for (int j = 0; j < interactions; j++) {
                edges[j][0] = sc.nextInt();
                edges[j][1] = sc.nextInt();
            }
            System.out.format("Scenario #%d: \n", i);
            b.findSuspiciousBug(noBug, edges);
        }
    }
}
