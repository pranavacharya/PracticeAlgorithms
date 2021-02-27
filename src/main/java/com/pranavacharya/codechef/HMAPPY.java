package com.pranavacharya.codechef;

import java.util.Scanner;

public class HMAPPY {

    private long findMinMaxCandies(long[] balloon, long[] candies, long available) {
        long low = 0;
        long high = (long) 1e18;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canSatisfy(balloon, candies, available, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    private boolean canSatisfy(long[] balloon, long[] candies, long available, long mid) {
        long ballonsNeeded = 0;
        for (int i = 0; i < balloon.length; i++) {
            long canCompensate = mid / candies[i];
            ballonsNeeded += Math.max(0L, balloon[i] - canCompensate);
        }
        return ballonsNeeded <= available;
    }

    public static void main(String[] args) {
        HMAPPY h = new HMAPPY();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();
        long[] balloons = new long[n];
        for (int i = 0; i < n; i++) {
            balloons[i] = sc.nextLong();
        }
        long[] candies = new long[n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextLong();
        }
        System.out.println(h.findMinMaxCandies(balloons, candies, m));
    }
}
