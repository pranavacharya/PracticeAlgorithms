package com.pranavacharya.hackerrank;

public class RecursionDavisStaircase {

    private final long mod = 10000000007L;

    private int[] memo;

    public int stepPerms(int n) {
        memo = new int[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        if (memo[n] == 0) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else if (n == 2) {
                return 2;
            } else if (n == 3) {
                return 4;
            } else {
                int ans = 0;
                ans = (int) (((int) (ans % mod) + (int) (helper(n - 1) % mod)) % mod);
                ans = (int) (((int) (ans % mod) + (int) (helper(n - 2) % mod)) % mod);
                ans = (int) (((int) (ans % mod) + (int) (helper(n - 3) % mod)) % mod);
                memo[n] = ans;
                return memo[n];
            }
        } else {
            return memo[n];
        }
    }

    public static void main(String args[]) {
        RecursionDavisStaircase rds = new RecursionDavisStaircase();
        System.out.println(rds.stepPerms(5));
    }
}
