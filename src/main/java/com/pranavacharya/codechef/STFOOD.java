package com.pranavacharya.codechef;

import java.util.Scanner;

public class STFOOD {

    private int findMaxProfit(int[][] arr) {
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            int stores = arr[i][0];
            int people = arr[i][1];
            int value = arr[i][2];
            int profit = (people / (stores + 1)) * value;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public static void main(String args[]) {
        STFOOD s = new STFOOD();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][3];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            sb.append(s.findMaxProfit(arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
