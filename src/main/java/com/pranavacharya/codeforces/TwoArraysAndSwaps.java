package com.pranavacharya.codeforces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TwoArraysAndSwaps {

    public int findMax(int[] a, int[] b, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        for (int i = 0; i < a.length; i++) {
            minHeap.add(a[i]);
            maxHeap.add(b[i]);
        }
        int max = 0;
        while (k > 0 && !minHeap.isEmpty() && !maxHeap.isEmpty()) {
            int aswap = minHeap.peek();
            int bswap = maxHeap.peek();
            if (aswap > bswap) {
                break;
            } else {
                minHeap.remove();
                maxHeap.remove();
                max += bswap;
            }
            k--;
        }
        while (!minHeap.isEmpty()) {
            max += minHeap.remove();
        }
        return max;
    }

    public static void main(String args[]) {
        TwoArraysAndSwaps taas = new TwoArraysAndSwaps();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int i = 1; i <= testCase; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }
            System.out.println(taas.findMax(a, b, k));
        }
    }
}
