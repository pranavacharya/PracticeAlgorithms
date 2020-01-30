package com.pranavacharya.algo;

public class SubsetRecursion {

    public static void subset(String soFar, String rem) {
        if (rem.isEmpty()) {
            System.out.println(soFar);
            return;
        }
            String letter = rem.substring(0, 1);
            subset(soFar.concat(letter), rem.substring(1, rem.length()));
            subset(soFar, rem.substring(1, rem.length()));
    }

    public static void main(String args[]) {
        subset("", "abcd");
    }
}
