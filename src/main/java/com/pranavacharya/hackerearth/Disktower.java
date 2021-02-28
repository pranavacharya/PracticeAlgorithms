package com.pranavacharya.hackerearth;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Disktower {

    private String placeTower(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int n = arr.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            while (!queue.isEmpty() && queue.peek() == n) {
                sb.append(queue.poll()).append(" ");
                n--;
            }
            sb.append("\n");
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Disktower dt = new Disktower();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(dt.placeTower(arr));
    }
}
