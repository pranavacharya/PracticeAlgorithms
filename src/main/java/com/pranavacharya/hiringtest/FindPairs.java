package com.pranavacharya.hiringtest;

import java.util.Arrays;

public class FindPairs {

    int boundedSquareSum(int[] a, int[] b, int lower, int upper) {
        long[] squarea = new long[a.length];
        for (int i = 0; i < a.length; i++) {
            squarea[i] = a[i] * a[i];
        }
        Arrays.sort(squarea);
        long[] squareb = new long[b.length];
        for (int i = 0; i < b.length; i++) {
            squareb[i] = b[i] * b[i];
        }
        Arrays.sort(squareb);
        int ans = 0;
        for (int i = 0; i < b.length; i++) {

            long val = squareb[i];

            long[] bound = findLowerUpperBound(squarea, lower - val);
            long[] bound2 = findLowerUpperBound(squarea, upper - val);

            ans += (bound2[1] - bound[0]);
        }
        return ans;
    }

    private long[] findLowerUpperBound(long[] a, long x) {
        int low = Arrays.binarySearch(a, x);
        int high = Arrays.binarySearch(a, x);
        if (low < 0) {
            low = Math.abs(low) - 1;
        } else {
            long y = a[low];
            for (int i = low - 1; i >= 0; i--) {
                if (a[i] == y) {
                    --low;
                } else {
                    break;
                }
            }
        }
        if (high < 0) {
            high = Math.abs(high) - 1;
        } else {
            long y = a[high];
            for (int i = high + 1; i < a.length; i++) {
                if (a[i] == y) {
                    ++high;
                } else {
                    break;
                }
            }
            ++high;
        }
        return new long[]{low, high};
    }

    public static void main(String[] args) {
        FindPairs fp = new FindPairs();
        int[] a = new int[]{3, -1, 9};
        int[] b = new int[]{100, 5, -2};
        System.out.println(fp.boundedSquareSum(a, b, 7, 99));
    }
}
