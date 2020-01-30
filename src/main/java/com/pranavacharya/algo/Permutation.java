package com.pranavacharya.algo;

public class Permutation {

    public static void permute(String soFar, String rem) {
        if (rem.isEmpty()) {
            System.out.println(soFar);
            return;
        }
        for (int i = 0; i < rem.length(); i++) {
            String letter = String.valueOf(rem.charAt(i));
            String before = rem.substring(0, i);
            String after = rem.substring(i + 1);
            permute(soFar.concat(letter), before.concat(after));
        }
    }

    public static void main(String args[]) {
        permute("", "abcd");
    }

}
