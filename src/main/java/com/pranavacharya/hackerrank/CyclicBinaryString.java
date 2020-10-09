package com.pranavacharya.hackerrank;

public class CyclicBinaryString {

    public static int maximumPower(String s) {
        int max = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        count = 0;
        int i = 0;
        for (i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        if (i == s.length()) {
            return -1;
        }
        for (i = s.toCharArray().length - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String args[]) {
        System.out.println(maximumPower("00110"));
        System.out.println(maximumPower("000"));
    }
}
