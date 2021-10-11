package com.pranavacharya.hiringtest;

import java.util.ArrayList;
import java.util.Arrays;

public class Mountain {

    int[] deleteMinimalPeaks(int[] numbers) {
        ArrayList<int[]> list = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            list.add(new int[]{numbers[i]});
        }

        int[] result = new int[numbers.length];
        int index = 0;

        while (!list.isEmpty()) {
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if (list.size() == 1) {
                    minIndex = i;
                    min = list.get(i)[0];
                    continue;
                }
                if (i == 0) {
                    if (list.get(i)[0] > list.get(i + 1)[0]) {
                        if (min > list.get(i)[0]) {
                            minIndex = i;
                            min = list.get(i)[0];
                        }
                    }
                    continue;
                }
                if (i == list.size() - 1) {
                    if (list.get(i)[0] > list.get(i - 1)[0]) {
                        if (min > list.get(i)[0]) {
                            minIndex = i;
                            min = list.get(i)[0];
                        }
                    }
                    continue;
                }
                if (list.get(i)[0] > list.get(i - 1)[0]
                        && list.get(i)[0] > list.get(i + 1)[0]) {
                    if (min > list.get(i)[0]) {
                        minIndex = i;
                        min = list.get(i)[0];
                    }
                }
            }
            result[index++] = list.get(minIndex)[0];
            list.remove(minIndex);
        }

        return result;
    }

    public static void main(String[] args) {
        Mountain m = new Mountain();
        int[] numbers = new int[]{2, 7, 8, 5, 1, 6, 3, 9, 4};
        System.out.println(Arrays.toString(m.deleteMinimalPeaks(numbers)));
    }
}
