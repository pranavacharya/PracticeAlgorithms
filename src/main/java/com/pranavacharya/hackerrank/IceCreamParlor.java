package com.pranavacharya.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class IceCreamParlor {

    private int[] findPairs(int[] costs, int money) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < costs.length; i++) {
            if (map.containsKey(costs[i])) {
                return new int[]{map.get(costs[i]), i};
            } else {
                map.put(money - costs[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        IceCreamParlor icp = new IceCreamParlor();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int money = sc.nextInt();
            int n = sc.nextInt();
            int[] costs = new int[n];
            for (int j = 0; j < n; j++) {
                costs[j] = sc.nextInt();
            }
            int[] ans = icp.findPairs(costs, money);
            sb.append(ans[0] + 1).append(" ").append(ans[1] + 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
