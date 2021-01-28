package com.pranavacharya.codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class Offer {

    private int maxItems(int k, int[] arr) {
        int cost = 0;
        HashMap<Integer, Integer> freq = new HashMap();
        int maxItems = 0;
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            if (arr[end] > k) {
                end++;
                start = end;
                cost = 0;
                continue;
            }
            if (!freq.containsKey(arr[end])) {
                while (arr[end] + cost > k) {
                    freq.put(arr[start], freq.get(arr[start]) - 1);
                    if (freq.get(arr[start]) == 0) {
                        freq.remove(arr[start]);
                        cost -= arr[start];
                    }
                    start++;
                }
                cost += arr[end];
            }
            freq.put(arr[end], freq.getOrDefault(arr[end], 0) + 1);
            maxItems = Math.max(maxItems, end - start + 1);
            end++;
        }

        return maxItems;
    }

    public static void main(String args[]) {
        Offer of = new Offer();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int k = sc.nextInt();
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(of.maxItems(k, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
