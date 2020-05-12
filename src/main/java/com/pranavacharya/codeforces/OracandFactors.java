package com.pranavacharya.codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class OracandFactors {

    HashMap<Integer, Integer> cache;

    public OracandFactors() {
        this.cache = new HashMap();
    }

    public int findFactors(int n, int k) {
        int ans = n + fFunction(n) + 2 * (k - 1);
        return ans;
    }

    public int fFunction(int n) {
        if (this.cache.containsKey(n)) {
            return this.cache.get(n);
        }
        boolean[] numbers = new boolean[n + 1];
        numbers[1] = true;
        for (int i = 2; i * i < numbers.length; i++) {
            if (numbers[i]) {
                continue;
            }
            for (int j = 2; i * j < numbers.length; j++) {
                numbers[i * j] = true;
            }
        }
        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i] && n % i == 0) {
                this.cache.put(n, i);
                return i;
            }
        }
        this.cache.put(n, n);
        return n;
    }

    public static void main(String args[]) {
        OracandFactors oaf = new OracandFactors();
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 1; i <= testcases; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(oaf.findFactors(n, k));
        }
    }
}
