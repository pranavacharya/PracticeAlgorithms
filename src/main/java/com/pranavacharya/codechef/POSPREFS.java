package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class POSPREFS {

    private ArrayList<Integer> findSeries(int n, int k) {
        ArrayList<Integer> series = new ArrayList();
        int[] arr = new int[n + 1];
        Arrays.fill(arr, -1);
        for (int i = 2; i <= n && k > 0; i = i + 2, k--) {
            arr[i] = 1;
        }

        for (int i = n; i > 0 && k > 0; i = i - 2, k--) {
            if (arr[i] == 1) {
                i--;
            }
            arr[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 1) {
                series.add(i);
            } else {
                series.add(-i);
            }
        }
        return series;
    }

    public static void main(String args[]) {
        POSPREFS p = new POSPREFS();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> series = p.findSeries(n, k);
            for (int j = 0; j < series.size(); j++) {
                sb.append(series.get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
