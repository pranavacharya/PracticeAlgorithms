package com.pranavacharya.spoj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ELEVTRBL {

    private int findButtonClicks(int f, int s, int g, int u, int d) {
        HashSet<Integer> visited = new HashSet();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{s, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            if (curr[0] == g) {
                return curr[1];
            }
            if (curr[0] + u <= f && !visited.contains(curr[0] + u)) {
                queue.add(new int[]{curr[0] + u, curr[1] + 1});
                visited.add(curr[0] + u);
            }
            if (curr[0] - d >= 1 && !visited.contains(curr[0] - d)) {
                queue.add(new int[]{curr[0] - d, curr[1] + 1});
                visited.add(curr[0] - d);
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        ELEVTRBL e = new ELEVTRBL();
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        int s = sc.nextInt();
        int g = sc.nextInt();
        int u = sc.nextInt();
        int d = sc.nextInt();
        int ans = e.findButtonClicks(f, s, g, u, d);
        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }
}
