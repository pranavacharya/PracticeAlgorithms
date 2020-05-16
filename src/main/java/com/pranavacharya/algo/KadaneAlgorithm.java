package com.pranavacharya.algo;

public class KadaneAlgorithm {

    public int maxSubarray(int[] arr) {
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            curr = Math.max(curr + a, a);
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String args[]) {
        KadaneAlgorithm ka = new KadaneAlgorithm();
        int[] arr = new int[]{4, 3, -3, 4, 5};
        System.out.println(ka.maxSubarray(arr));
    }

}
