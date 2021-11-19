package com.pranavacharya.hackerrank;

import java.util.Arrays;
import java.util.List;

public class ClassSchedule {

    public static String isConflict(List<List<Integer>> timings) {
        int[][] arr = new int[timings.size()][2];
        for (int i = 0; i < timings.size(); i++) {
            arr[i][0] = timings.get(i).get(0);
            arr[i][1] = timings.get(i).get(1);
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][1] > arr[i - 1][1]) {
                return "True";
            }
        }
        return "False";
    }
}
