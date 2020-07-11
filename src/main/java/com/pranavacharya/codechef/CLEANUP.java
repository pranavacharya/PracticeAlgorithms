package com.pranavacharya.codechef;

import java.util.Scanner;

public class CLEANUP {

    public String[] findJob(int[] jobs) {
        StringBuilder c = new StringBuilder();
        StringBuilder a = new StringBuilder();
        boolean cturn = true;
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i] == 0) {
                if (cturn) {
                    c.append(i).append(" ");
                } else {
                    a.append(i).append(" ");
                }
                cturn = !cturn;
            }
        }
        return new String[]{c.toString().trim(), a.toString().trim()};
    }

    public static void main(String args[]) {
        CLEANUP c = new CLEANUP();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] jobs = new int[n + 1];
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                jobs[sc.nextInt()] = 1;
            }
            String[] tasks = c.findJob(jobs);
            sb.append(tasks[0]).append("\n");
            sb.append(tasks[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
