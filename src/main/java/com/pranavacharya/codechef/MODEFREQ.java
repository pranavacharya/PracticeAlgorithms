package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class MODEFREQ {

    public int findMode(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        HashMap<Integer, Integer> freq = new HashMap();
        for (int i : map.values()) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        int max = 0;
        int val = 0;
        for (int i : freq.keySet()) {
            if (freq.get(i) > val) {
                max = i;
                val = freq.get(i);
            } else if (freq.get(i) == val) {
                if (i < max) {
                    max = i;
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        MODEFREQ m = new MODEFREQ();
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(m.findMode(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
