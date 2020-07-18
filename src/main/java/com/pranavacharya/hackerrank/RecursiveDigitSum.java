package com.pranavacharya.hackerrank;

public class RecursiveDigitSum {

    public int superDigit(String n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(n);
        }
        return (int) helper(sb.toString());
    }

    public long helper(String n) {
        if (n.length() == 0) {
            return 0;
        } else if (n.length() == 1) {
            return Integer.parseInt(n);
        } else {
            return helper(sum(n));
        }
    }

    public String sum(String n) {
        long ans = 0;
        for (char c : n.toCharArray()) {
            ans += (c - '0');
        }
        return "" + ans;
    }

    public static void main(String args[]) {
        RecursiveDigitSum rds = new RecursiveDigitSum();
        System.out.println(rds.superDigit("148", 3));
    }
}
