package com.pranavacharya.binarysearch;

public class BipartiteGraph {

    public boolean solve(int[][] graph) {
        int[] colors = new int[graph.length + 1];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !helper(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return color == colors[node];
        }

        colors[node] = color;
        for (int i = 0; i < graph[node].length; i++) {

            if (!helper(graph, colors, -1 * color, graph[node][i])) {
                return false;
            }
        }

        return true;
    }
}
