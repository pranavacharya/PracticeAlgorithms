package com.pranavacharya.codechef;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CHEFPAT {

    private int[] fingWaitingPeriod(int[] p) {
        int[] ans = new int[p.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (p[a] == p[b] ? a - b : p[b] - p[a]));
        for (int i = 0; i < p.length; i++) {
            queue.add(i);
        }
        int time = 1;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            ans[index] = time;
            time++;
        }
        return ans;
    }

    public static void main(String args[]) {
        CHEFPAT c = new CHEFPAT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] patients = new int[n];
            for (int j = 0; j < n; j++) {
                patients[j] = sc.nextInt();
            }
            int[] ans = c.fingWaitingPeriod(patients);
            for (int k = 0; k < ans.length; k++) {
                sb.append(ans[k]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
