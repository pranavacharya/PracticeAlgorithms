package com.pranavacharya.hackerrank;

import java.util.Arrays;
import java.util.List;

public class WaterPlants {

    public static int waterPlants(List<Integer> plants) {
        int cost = 0;
        int[] arr = new int[plants.size()];
        Arrays.fill(arr, 1);
        for (int i = 1; i < plants.size(); i++) {
            if (plants.get(i) > plants.get(i - 1)) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = plants.size() - 2; i >= 0; i--) {
            if (plants.get(i) > plants.get(i + 1)) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            cost += arr[i];
        }
        return cost;
    }

}
