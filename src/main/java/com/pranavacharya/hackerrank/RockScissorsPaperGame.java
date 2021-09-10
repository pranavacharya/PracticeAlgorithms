package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RockScissorsPaperGame {

    private HashMap<Integer, Integer> sameSet = new HashMap();

    private HashMap<Integer, List<Integer>> beats = new HashMap();

    private void union(int x, int y) {
        int x1 = findParent(x);
        int y1 = findParent(y);
        this.sameSet.put(x1, y1);
    }

    private int findParent(int x) {
        int key = x;
        while (this.sameSet.containsKey(x) && this.sameSet.get(x) != x) {
            x = this.sameSet.get(x);
        }
        this.sameSet.put(key, x);
        return x;
    }

    private void unionBeats(int x, int y) {
        int x1 = findParent(x);
        int y1 = findParent(y);
        this.beats.get(x1).add(y1);
    }

    private int countFlawedProps(int n, int k, int[][] arr) {
        for (int i = 1; i <= n; i++) {
            this.beats.put(i, new ArrayList());
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 1) {
                // same condition
                int parent1 = findParent(arr[i][1]);
                int parent2 = findParent(arr[i][2]);
                if (this.beats.get(parent1).contains(parent2) || this.beats.get(parent2).contains(parent1)) {
                    count++;
                } else {
                    union(arr[i][1], arr[i][2]);
                }
            } else {
                // beats
                int parent1 = findParent(arr[i][1]);
                int parent2 = findParent(arr[i][2]);

                if (this.beats.get(parent2).contains(parent1) || parent1 == parent2) {
                    count++;
                } else {
                    unionBeats(arr[i][1], arr[i][2]);
                }
            }
        }
        System.out.println(this.beats);
        System.out.println(this.sameSet);
        return count;
    }

    public static void main(String[] args) {
        RockScissorsPaperGame rspg = new RockScissorsPaperGame();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[k][3];
        for (int i = 0; i < k; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        System.out.println(rspg.countFlawedProps(n, k, arr));
    }

}
