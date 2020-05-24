package com.pranavacharya.codechef;

import java.util.HashSet;
import java.util.Scanner;

public class CHEFRECP {

    public boolean isPrepared(int[] arr) {
        HashSet<Integer> elements = new HashSet();
        HashSet<Integer> frequency = new HashSet();
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            while (end + 1 < arr.length && arr[end] == arr[end + 1]) {
                end++;
            }
            if (elements.contains(arr[start])) {
                return false;
            }
            if (frequency.contains(end - start + 1)) {
                return false;
            }
            elements.add(arr[start]);
            frequency.add(end - start + 1);
            end++;
            start = end;
        }
        return true;
    }

    public static void main(String args[]) {
        CHEFRECP c = new CHEFRECP();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            if (c.isPrepared(arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
