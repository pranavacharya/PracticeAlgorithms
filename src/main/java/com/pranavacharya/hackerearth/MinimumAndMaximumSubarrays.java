package com.pranavacharya.hackerearth;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MinimumAndMaximumSubarrays {

    private void printMaxMin(int[] arr, int k) {
        StringBuilder sbMax = new StringBuilder();
        StringBuilder sbMin = new StringBuilder();
        Deque<Integer> maxQueue = new ArrayDeque();
        Deque<Integer> minQueue = new ArrayDeque();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[j]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(j);
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[j]) {
                minQueue.pollLast();
            }
            minQueue.addLast(j);
            j++;
            if (j - i == k) {
                sbMax.append(arr[maxQueue.peekFirst()]).append(" ");
                sbMin.append(arr[minQueue.peekFirst()]).append(" ");

                if (maxQueue.peekFirst() == i) {
                    maxQueue.pollFirst();
                }
                if (minQueue.peekFirst() == i) {
                    minQueue.pollFirst();
                }
                i++;
            }
        }
        System.out.println(sbMax.toString());
        System.out.println(sbMin.toString());
    }

    public static void main(String[] args) {
        MinimumAndMaximumSubarrays mams = new MinimumAndMaximumSubarrays();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        mams.printMaxMin(arr, k);
    }
}
