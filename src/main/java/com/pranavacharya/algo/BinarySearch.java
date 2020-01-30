package com.pranavacharya.algo;

public class BinarySearch {

    public int searchInsert(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int mid = 0;
        int index = -1;
        while (low <= high) {
            mid = (high + low) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();
        int[] ip = {1,3};
        System.out.println(bs.searchInsert(ip, 3));
    }
}
