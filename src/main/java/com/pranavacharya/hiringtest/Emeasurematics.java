package com.pranavacharya.hiringtest;

public class Emeasurematics {

    public static int findPower(int num) {
        int ans = 1;
        while (ans * 2 <= num) {
            ans = ans * 2;
        }
        return ans;
    }

    public static boolean canReach(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, i + arr[i]);
        }
        return max >= arr.length - 1;
    }

    public static int findMissing(int[] arr) {
        int[] freq = new int[arr.length + 1];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (freq[arr[i]] == 1) {
                sum += arr[i];
            }
            freq[arr[i]] = 1;

        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("Hello");
        
        System.out.println(findPower(100));

        int[] arr = new int[]{1, 2, 3};
        int[] arr1 = new int[]{5, 0, 0, 0};
        int[] arr2 = new int[]{0};
        int[] arr3 = new int[]{0, 2, 4};
        int[] arr4 = new int[]{1, 2, 0, 0, 1};
        int[] arr5 = new int[]{1, 2, 0, 1, 0};
        System.out.println(canReach(arr));
        System.out.println(canReach(arr1));
        System.out.println(canReach(arr2));
        System.out.println(canReach(arr3));
        System.out.println(canReach(arr4));
        System.out.println(canReach(arr5));

        int[] test = new int[]{1, 1, 3, 4};
        int[] test2 = new int[]{6, 3, 2, 4, 3, 1};
        System.out.println(findMissing(test));
        System.out.println(findMissing(test2));

    }
}
