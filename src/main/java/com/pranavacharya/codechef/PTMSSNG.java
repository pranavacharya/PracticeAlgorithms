package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class PTMSSNG {

    public int[] findVertex(int n, int[][] points) {
        HashMap<Integer, Integer> xfrequency = new HashMap();
        HashMap<Integer, Integer> yfrequency = new HashMap();

        for (int[] point : points) {
            xfrequency.put(point[0], xfrequency.getOrDefault(point[0], 0) + 1);
            yfrequency.put(point[1], yfrequency.getOrDefault(point[1], 0) + 1);
        }
        int[] ans = new int[2];
        for (int k : xfrequency.keySet()) {
            if (xfrequency.get(k) % 2 != 0) {
                ans[0] = k;
                break;
            }
        }
        for (int k : yfrequency.keySet()) {
            if (yfrequency.get(k) % 2 != 0) {
                ans[1] = k;
                break;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        PTMSSNG p = new PTMSSNG();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            n *= 4;
            int[][] points = new int[n - 1][2];
            for (int j = 0; j < n - 1; j++) {
                points[j][0] = sc.nextInt();
                points[j][1] = sc.nextInt();
            }
            int[] vertex = p.findVertex(n, points);
            sb.append(vertex[0]).append(" ").append(vertex[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
