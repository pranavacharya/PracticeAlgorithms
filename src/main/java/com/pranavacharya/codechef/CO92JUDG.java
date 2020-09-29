package com.pranavacharya.codechef;

import java.util.Scanner;

public class CO92JUDG {

    public String findWinner(int[] alice, int[] bob) {
        int aSum = 0;
        int maxAlice = 0;
        for (int i = 0; i < alice.length; i++) {
            aSum += alice[i];
            maxAlice = Math.max(maxAlice, alice[i]);
        }
        aSum -= maxAlice;
        int bSum = 0;
        int maxBob = 0;
        for (int i = 0; i < bob.length; i++) {
            bSum += bob[i];
            maxBob = Math.max(maxBob, bob[i]);
        }
        bSum -= maxBob;
        if (aSum == bSum) {
            return "Draw";
        } else if (aSum < bSum) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public static void main(String args[]) {
        CO92JUDG c = new CO92JUDG();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] alice = new int[n];
            int[] bob = new int[n];
            for (int j = 0; j < n; j++) {
                alice[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                bob[j] = sc.nextInt();
            }
            sb.append(c.findWinner(alice, bob)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
