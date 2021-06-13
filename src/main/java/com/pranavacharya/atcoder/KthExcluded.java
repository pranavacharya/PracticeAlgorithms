package com.pranavacharya.atcoder;

import java.util.Arrays;
import java.util.Scanner;

public class KthExcluded {

    private long[] findAns(long[] arr, long[] queries) {
        long[] ans = new long[queries.length];
        Arrays.sort(arr);
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
            long lastValid = 0;
            int lastValidIndex = -1;
            for (int j = 0; j < prefix.length; j++) {
                if (prefix[j] >= query) {
                    break;
                }
                lastValid = arr[j];
                lastValidIndex = j;
            }
            ans[i] = lastValid + query;
            if (lastValidIndex != -1) {
                ans[i] -= prefix[lastValidIndex];
            }
        }
        return ans;
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
