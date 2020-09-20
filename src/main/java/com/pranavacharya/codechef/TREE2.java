package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class TREE2 {

    public int findMin(int[] arr) {
        Arrays.sort(arr);
        int index = arr.length - 1;
        int min = 0;
        for (int i = index; i >= 0; i--) {
            while (i - 1 >= 0) {
                if (arr[i - 1] == arr[i]) {
                    i--;
                } else {
                    break;
                }
            }
            if (arr[i] != 0) {
                min++;
            }
        }
        return min;
    }

    public static void main(String args[]) {
        TREE2 t = new TREE2();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(t.findMin(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
