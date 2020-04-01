package com.pranavacharya.algo;

import java.util.ArrayList;

public class PrimeFactorsOfNumber {

    public ArrayList primeFactors(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] numbers = new boolean[num + 1];
        numbers[1] = true;
        for (int i = 2; i * i < numbers.length; i++) {
            if (numbers[i]) {
                continue;
            }
            for (int j = 2; i * j < numbers.length; j++) {
                numbers[i * j] = true;
            }
        }

        for (int i = 1; i < numbers.length; i++) {
            if (!numbers[i] && num % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String args[]) {
        PrimeFactorsOfNumber pfn = new PrimeFactorsOfNumber();
        System.out.println(pfn.primeFactors(789));
    }
}
