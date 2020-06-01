package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DIGJUMP {

    public int findShortedPath(String ip) {
        ArrayList<Integer>[] adj = new ArrayList[ip.length()];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
        HashSet<Integer>[] nums = new HashSet[10];
        for (int i = 0; i <= 9; i++) {
            nums[i] = new HashSet();
        }
        for (int i = 0; i < ip.length() - 1; i++) {
            adj[i].add(i + 1);
            adj[i + 1].add(i);
            for (int j : nums[ip.charAt(i) - '0']) {
                if (!adj[j].contains(i)) {
                    adj[j].add(i);
                }
                if (!adj[i].contains(j)) {
                    adj[i].add(j);
                }
            }
            nums[ip.charAt(i) - '0'].add(i);
        }
        for (int j : nums[ip.charAt(ip.length() - 1) - '0']) {
            if (!adj[j].contains(ip.length() - 1)) {
                adj[j].add(ip.length() - 1);
            }
            if (!adj[ip.length() - 1].contains(j)) {
                adj[ip.length() - 1].add(j);
            }
        }
        nums[ip.charAt(ip.length() - 1) - '0'].add(ip.length() - 1);
        boolean[] visited = new boolean[ip.length()];
        Queue<int[]> bfs = new LinkedList();
        bfs.add(new int[]{0, 0});
        while (!bfs.isEmpty()) {
            int[] current = bfs.poll();
            visited[current[0]] = true;
            if (current[0] == ip.length() - 1) {
                return current[1];
            }
            for (int nei : adj[current[0]]) {
                if (visited[nei]) {
                    continue;
                }
                bfs.add(new int[]{nei, current[1] + 1});
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        DIGJUMP d = new DIGJUMP();
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        System.out.println(d.findShortedPath(ip));
    }
}
