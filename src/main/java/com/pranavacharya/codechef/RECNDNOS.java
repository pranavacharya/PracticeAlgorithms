package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class RECNDNOS {

    public int findMaxDish(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        boolean lastIncluded = true;
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i - 1] == arr[i] && lastIncluded) {
                lastIncluded = false;
            } else {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                lastIncluded = true;
            }
        }
        int max = 0;
        int ans = arr[0];
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                ans = Math.min(ans, key);
            }
            if (map.get(key) > max) {
                max = map.get(key);
                ans = key;
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        RECNDNOS r = new RECNDNOS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(r.findMaxDish(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
