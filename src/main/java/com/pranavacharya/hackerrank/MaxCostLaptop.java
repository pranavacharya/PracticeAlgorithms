package com.pranavacharya.hackerrank;

import java.util.List;

public class MaxCostLaptop {

    public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount) {
        // Write your code here
        int max_cost = 0;
        int local = 0;
        int count = 0;
        for (int i = 0; i < cost.size(); i++) {
            if (labels.get(i).equals("legal")) {
                local += cost.get(i);
                count++;
                if (count == dailyCount) {
                    max_cost = Math.max(max_cost, local);
                    local = 0;
                    count = 0;
                }
            } else {
                local += cost.get(i);
            }
        }

        return max_cost;
    }
}
