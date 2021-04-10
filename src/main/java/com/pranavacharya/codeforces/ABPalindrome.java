package com.pranavacharya.codeforces;

import java.util.Scanner;

public class ABPalindrome {

    private String findString(int a, int b, String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int q = 0;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] != '?' && arr[n - i - 1] != '?') {
                if (arr[i] != arr[n - i - 1]) {
                    return "-1";
                } else {
                    if (arr[i] == '0') {
                        a -= 2;
                    } else {
                        b -= 2;
                    }
                }
            } else {
                if (arr[i] == '?' && arr[n - i - 1] == '?') {
                    q += 2;
                } else if (arr[i] == '?') {
                    if (arr[n - i - 1] == '0') {
                        a -= 2;
                        arr[i] = '0';
                    } else {
                        arr[i] = '1';
                        b -= 2;
                    }
                } else {
                    if (arr[i] == '0') {
                        arr[n - i - 1] = '0';
                        a -= 2;
                    } else {
                        arr[n - i - 1] = '1';
                        b -= 2;
                    }
                }
            }
            if (a < 0 || b < 0) {
                return "-1";
            }
        }
        if (a + b < q) {
            return "-1";
        }
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] == '?') {
                if (a > 1) {
                    arr[i] = '0';
                    arr[n - i - 1] = '0';
                    a -= 2;
                } else if (b > 1) {
                    arr[i] = '1';
                    arr[n - i - 1] = '1';
                    b -= 2;
                } else {
                    return "-1";
                }
            }
        }
        if (n % 2 == 1) {
            if (arr[n / 2] == '?') {
                if (a > 0) {
                    a--;
                    arr[n / 2] = '0';
                } else if (b > 0) {
                    b--;
                    arr[n / 2] = '1';
                } else {
                    return "-1";
                }
            } else {
                if (arr[n / 2] == '0') {
                    a--;
                } else {
                    b--;
                }
            }
        }
        if (a == 0 && b == 0) {
            return new String(arr);
        } else {
            return "-1";
        }
    }

    public static void main(String[] args) {
        ABPalindrome abp = new ABPalindrome();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = sc.next();
            sb.append(abp.findString(a, b, s)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
