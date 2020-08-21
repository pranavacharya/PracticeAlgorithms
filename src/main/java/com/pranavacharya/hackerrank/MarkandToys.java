package com.pranavacharya.hackerrank;

import java.util.Arrays;

public class MarkandToys {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int toys = 0;
        Arrays.sort(prices);
        for (int i = 0; i < prices.length && k > 0; i++) {
            if (k - prices[i] > 0) {
                toys++;
                k -= prices[i];
            } else {
                break;
            }
        }
        return toys;
    }

    public static void main(String args[]) {
        int[] prices = new int[]{1, 12, 5, 111, 200, 1000, 10};
        System.out.println(maximumToys(prices, 50));
    }
}
