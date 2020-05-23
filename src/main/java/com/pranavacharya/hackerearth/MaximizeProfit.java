package com.pranavacharya.hackerearth;

import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximizeProfit {

    public long solution(int n, int[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> (a[x] - a[y]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> (a[y] - a[x]));
        HashSet<Integer> visited = new HashSet();
        for (int i = 0; i < a.length; i++) {
            minHeap.add(i);
            maxHeap.add(i);
        }
        long sum = 0;
        while (maxHeap.size() > 2 && !minHeap.isEmpty()) {
            visited.add(minHeap.remove());
            if (visited.contains(maxHeap.remove())) {
                break;
            }
            int middleIndex = maxHeap.remove();
            if (visited.contains(middleIndex)) {
                break;
            }
            sum += a[middleIndex];
        }
        return sum;
    }

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long ans = solution(n, a);
            System.out.println(ans);
        }
    }

    public static void main(String args[]) throws IOException {
        new MaximizeProfit().run();
    }
}
