package com.pranavacharya.hiringtest;

public class CodeString {

    private String findString(String s) {
        String longest = longestPalindrom(s);
        if (longest.length() >= 2) {
            return findString(s.substring(longest.length()));
        } else {
            return s;
        }
    }

    private String longestPalindrom(String s) {
        int j = s.length();
        while (j > 0) {
            j--;
            boolean flag = true;
            for (int l = 0; l < (j + 1) / 2; l++) {
                if (s.charAt(l) != s.charAt(j - l)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return s.substring(0, j + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        CodeString cs = new CodeString();
        System.out.println(cs.findString("aacodedoc"));
        System.out.println(cs.findString("aabaaacodedocb"));
        System.out.println(cs.findString("dcbaabcd"));
        System.out.println(cs.findString("codesignal"));
    }
}
