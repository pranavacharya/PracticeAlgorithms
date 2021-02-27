package com.pranavacharya.hackerearth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonkandPowerofTime {

    private int timeTaken(int[] calling, int[] ideal) {
        int time = 0;
        Queue<Integer> cqueue = new LinkedList();
        for (int i = 0; i < calling.length; i++) {
            cqueue.add(calling[i]);
        }

        int j = 0;
        while (j < ideal.length) {
            while (ideal[j] != cqueue.peek()) {
                cqueue.add(cqueue.poll());
                time++;
            }
            cqueue.poll();
            time++;
            j++;
        }

        return time;
    }

    public static void main(String[] args) {
        MonkandPowerofTime mpt = new MonkandPowerofTime();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] calling = new int[n];
        for (int i = 0; i < n; i++) {
            calling[i] = sc.nextInt();
        }

        int[] ideal = new int[n];
        for (int i = 0; i < n; i++) {
            ideal[i] = sc.nextInt();
        }

        System.out.println(mpt.timeTaken(calling, ideal));
    }
}
