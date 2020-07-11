package com.pranavacharya.atcoder;

import java.util.Scanner;

public class AnythingGoestoZero {

    public int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public int countOnes(String binary) {
        int count = 0;
        for (char d : binary.toCharArray()) {
            if (d == '1') {
                count++;
            }
        }
        return count;
    }

    public String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public int modulus(String str, int n, int k) {
        int pT[] = new int[n];
        pT[0] = 1 % k;
        for (int i = 1; i < n; i++) {
            pT[i] = pT[i - 1] * (2 % k);
            pT[i] %= k;
        }
        int res = 0;
        int i = 0, j = n - 1;
        while (i < n) {
            if (str.charAt(j) == '1') {
                res += (pT[i]);
                res %= k;
            }
            i++;
            j--;
        }
        return res;
    }

    public static void main(String args[]) {
        AnythingGoestoZero azo = new AnythingGoestoZero();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        String x = sc.next();
        char[] xarr = x.toCharArray();
        for (int i = 0; i < xarr.length; i++) {
            int count = 0;
            if (xarr[i] == '1') {
                xarr[i] = '0';
            } else {
                xarr[i] = '1';
            }
            String binaryString = String.valueOf(xarr);
            while (azo.countOnes(binaryString) != 0) {
                count++;
                int ones = azo.countOnes(binaryString);
                int val = azo.modulus(binaryString, binaryString.length(), ones);
                binaryString = azo.decimalToBinary(val);
            }
            if (xarr[i] == '1') {
                xarr[i] = '0';
            } else {
                xarr[i] = '1';
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
