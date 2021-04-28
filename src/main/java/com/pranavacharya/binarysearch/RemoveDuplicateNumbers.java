package com.pranavacharya.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicateNumbers {

    public int[] solve(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer> keys = new ArrayList();

        for (int key : nums) {
            if (map.get(key) == 1) {
                keys.add(key);
            }
        }

        int[] ans = new int[keys.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = keys.get(i);
        }
        return ans;
    }
}
