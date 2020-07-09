package com.pranavacharya.codechef;

import java.util.Scanner;

public class CNOTE {

    public String isLucky(int x, int y, int k, int[][] options) {
        int pages = x - y;
        for (int[] option : options) {
            if (option[0] >= pages && option[1] <= k) {
                return "LuckyChef";
            }
        }
        return "UnluckyChef";
    }

    public static void main(String args[]) {
        CNOTE c = new CNOTE();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] options = new int[n][2];
            for (int j = 0; j < n; j++) {
                options[j][0] = sc.nextInt();
                options[j][1] = sc.nextInt();
            }
            sb.append(c.isLucky(x, y, k, options)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
