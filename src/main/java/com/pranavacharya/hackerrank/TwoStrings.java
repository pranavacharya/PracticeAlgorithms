package com.pranavacharya.hackerrank;

import java.util.HashSet;

public class TwoStrings {

    public String twoStrings(String s1, String s2) {
        HashSet<Character> set = new HashSet();
        for (char c : s1.toCharArray()) {
            set.add(c);
        }
        for (char c : s2.toCharArray()) {
            if (set.contains(c)) {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String args[]) {
        TwoStrings ts = new TwoStrings();
        System.out.println(ts.twoStrings("hello", "world"));
        System.out.println(ts.twoStrings("hi", "world"));
    }
}
