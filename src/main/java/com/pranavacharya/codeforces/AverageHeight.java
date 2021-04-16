package com.pranavacharya.codeforces;

import java.util.ArrayList;
import java.util.Scanner;

public class AverageHeight {

    private int[] findPhotogenicOrder(int[] arr) {
        ArrayList<Integer> odd = new ArrayList();
        ArrayList<Integer> even = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }

        int index = 0;
        for (int i = 0; i < odd.size(); i++) {
            arr[index++] = odd.get(i);
        }
        for (int i = 0; i < even.size(); i++) {
            arr[index++] = even.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        AverageHeight ah = new AverageHeight();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[] ans = ah.findPhotogenicOrder(arr);
            for (int j = 0; j < n; j++) {
                sb.append(ans[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
