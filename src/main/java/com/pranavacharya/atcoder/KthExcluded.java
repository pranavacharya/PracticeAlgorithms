package com.pranavacharya.atcoder;

import java.util.Scanner;

public class KthExcluded {

    private long[] findAns(long[] arr, long[] queries) {
        long[] ans = new long[queries.length];
        long[] prefix = new long[arr.length];
        long last = 0;
        for (int i = 0; i < arr.length; i++) {
            prefix[i] = arr[i] - last - 1;
            last = arr[i];
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            long query = queries[i];
            int lastValidIndex = binarySearch(prefix, query);
            if (lastValidIndex < 0) {
                lastValidIndex = -1 * (lastValidIndex + 1);
            }
            long lastValid = 0;
            lastValidIndex--;
            if (lastValidIndex != -1) {
                lastValid = arr[lastValidIndex];
                ans[i] = -prefix[lastValidIndex];
            }
            ans[i] += lastValid + query;
        }
        return ans;
    }

    public static int binarySearch(long[] a, long key) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (mid > 0 && a[mid - 1] >= key) //we already know midval>=key here
            {
                high = mid - 1;
            } else if (midVal == key) //found the 1st key
            {
                return mid;
            } else {
                return ~mid;      //found insertion point
            }
        }
        return ~(a.length);       //insertion point after everything
    }

    public static void main(String[] args) {
        KthExcluded ke = new KthExcluded();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] arr = new long[n];
        long[] queries = new long[q];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextLong();
        }
        long[] ans = ke.findAns(arr, queries);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
