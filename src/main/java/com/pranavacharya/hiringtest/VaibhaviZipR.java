package com.pranavacharya.hiringtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VaibhaviZipR {

    private String solution(int[][] operations) {
        StringBuilder sb = new StringBuilder();
        List<Integer> obstacles = new ArrayList();
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                int index = Collections.binarySearch(obstacles, operation[1]);
                index = -1 * (index + 1);
                System.out.println(index);
                obstacles.add(index, operation[1]);
            } else {
                int first = operation[1];
                int second = first + operation[2] - 1;
                int indexFirst = Collections.binarySearch(obstacles, first);
                int indexSecond = Collections.binarySearch(obstacles, second);
                if (indexFirst < 0 && indexFirst == indexSecond) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        }
        return sb.toString();
    }

    private int countSubArray(int[] nums, int[] pattern) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int localcount = 0;
            for (int j = 0; j < pattern.length; j++) {
                if (pattern[j] == 1) {
                    if (nums[i + j] > nums[i + j - 1]) {
                        localcount++;
                    } else {
                        break;
                    }
                } else if (pattern[j] == 0) {
                    if (nums[i + j] == nums[i + j - 1]) {
                        localcount++;
                    } else {
                        break;
                    }
                } else {
                    if (nums[i + j] < nums[i + j - 1]) {
                        localcount++;
                    } else {
                        break;
                    }
                }
            }
            if (localcount == pattern.length) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        VaibhaviZipR vz = new VaibhaviZipR();
        int[][] operations = new int[][]{{1, 2}, {1, 5}, {2, 3, 2}, {2, 3, 3}, {2, 1, 1}, {2, 1, 2}};
        System.out.println(vz.solution(operations));
        int[] nums = new int[]{4, 1, 3, 4, 4, 5, 5, 1};
        int[] pattern = new int[]{1, 0, -1};
        System.out.println(vz.countSubArray(nums, pattern));
    }
}
