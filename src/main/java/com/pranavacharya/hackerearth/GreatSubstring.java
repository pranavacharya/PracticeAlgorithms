package com.pranavacharya.hackerearth;

public class GreatSubstring {

    static long Solve(int N, String S) {
        int count = 0;
        int mod = (int) 1e9 + 7;
        int[] freq = new int[26];
        for (int i = 0; i < S.length(); i++) {
            freq[S.charAt(i) - 'a']++;
            for (int j = i + 1; j < S.length(); j++) {
                freq[S.charAt(j) - 'a']++;
                if (isEven(freq)) {
                    count = (count % mod + 1 % mod) % mod;
                }
            }
            for (int j = i + 1; j < S.length(); j++) {
                freq[S.charAt(j) - 'a']--;
            }
            freq[S.charAt(i) - 'a']--;
        }
        return count;
    }

    static boolean isEven(int[] freq) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
