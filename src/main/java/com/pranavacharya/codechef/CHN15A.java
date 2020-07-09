package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHN15A {

    public int countWolverineMinion(int[] minions, int k) {
        int count = 0;
        for (int minion : minions) {
            if ((minion + k) % 7 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CHN15A c = new CHN15A();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] minions = new int[n];
            for (int j = 0; j < n; j++) {
                minions[j] = sc.nextInt();
            }
            sb.append(c.countWolverineMinion(minions, k)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
