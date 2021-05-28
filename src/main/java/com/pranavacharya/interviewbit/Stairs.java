package com.pranavacharya.interviewbit;

public class Stairs {

    public int climbStairs(int A) {
        int[] dp = new int[A + 1];
        dp[1] = 1;
        if (A == 1) {
            return dp[A];
        }
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[A];
    }

    public static void main(String[] args) {
        Stairs s = new Stairs();
        System.out.println(s.climbStairs(3));
    }
}
