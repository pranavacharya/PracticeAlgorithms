package com.pranavacharya.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

public class FindLocalPeaks {

    public int[] solve(int[] nums) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums.length > 1 && nums[0] > nums[i + 1]) {
                list.add(i);
                continue;
            }
            if (i == nums.length - 1 && i != 0 && nums[i] > nums[i - 1]) {
                list.add(i);
                continue;
            }
            if (i > 0 && i < nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                list.add(i);
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        FindLocalPeaks flp = new FindLocalPeaks();
        int[] nums = new int[]{1, 2, 3, 2, 4};
        System.out.println(Arrays.toString(flp.solve(nums)));
    }
}
