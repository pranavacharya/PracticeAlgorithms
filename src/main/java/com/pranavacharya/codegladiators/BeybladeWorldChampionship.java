package com.pranavacharya.codegladiators;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BeybladeWorldChampionship {

    public void maxWin(PriorityQueue<Long> t1, PriorityQueue<Long> t2) {
        int count = 0;
        while (!t1.isEmpty() && !t2.isEmpty()) {
            if (t1.peek() > t2.peek()) {
                count++;
                t1.remove();
                t2.remove();
            } else {
                t2.remove();
            }
        }
        System.out.println(count);
    }

    public static void main(String args[]) {
        BeybladeWorldChampionship bc = new BeybladeWorldChampionship();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            PriorityQueue<Long> t1 = new PriorityQueue<>((a, b) -> ((int) (b - a)));
            PriorityQueue<Long> t2 = new PriorityQueue<>((a, b) -> ((int) (b - a)));
            for (int j = 0; j < N; j++) {
                t1.add(sc.nextLong());
            }
            for (int j = 0; j < N; j++) {
                t2.add(sc.nextLong());
            }
            bc.maxWin(t1, t2);
        }
    }
}
