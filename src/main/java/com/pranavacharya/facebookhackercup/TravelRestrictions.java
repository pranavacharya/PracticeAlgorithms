package com.pranavacharya.facebookhackercup;

import java.util.Scanner;

public class TravelRestrictions {

    public String findMatrix(int t, int n, String in, String out) {
        char[] inarr = in.toCharArray();
        char[] outarr = out.toCharArray();
        char[][] output = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    output[i][j] = 'Y';
                } else if (outarr[i] == 'Y' && inarr[j] == 'Y') {
                    boolean flag = true;
                    for (int m = i; m < j; m++) {
                        if (outarr[m] == 'N') {
                            flag = false;
                            break;
                        }
                    }
                    for (int m = i + 1; m <= j && flag; m++) {
                        if (inarr[m] == 'N') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        output[i][j] = 'Y';
                    } else {
                        output[i][j] = 'N';
                    }
                } else {
                    output[i][j] = 'N';
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i == j) {
                    output[i][j] = 'Y';
                } else if (outarr[i] == 'Y' && inarr[j] == 'Y') {
                    boolean flag = true;
                    for (int m = j + 1; m < i; m++) {
                        if (outarr[m] == 'N') {
                            flag = false;
                            break;
                        }
                    }
                    for (int m = j; m <= i - 1 && flag; m++) {
                        if (inarr[m] == 'N') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        output[i][j] = 'Y';
                    } else {
                        output[i][j] = 'N';
                    }
                } else {
                    output[i][j] = 'N';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Case #" + t + ": ").append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(output[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        TravelRestrictions tr = new TravelRestrictions();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            String in = sc.next();
            String out = sc.next();
            sb.append(tr.findMatrix(i, n, in, out));
        }
        System.out.println(sb.toString());
    }
}
