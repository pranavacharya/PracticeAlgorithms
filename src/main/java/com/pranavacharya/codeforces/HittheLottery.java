package com.pranavacharya.codeforces;

import java.util.Scanner;

public class HittheLottery {

    private int[] deno = new int[]{1, 5, 10, 20, 100};

    private int findMinBills(int amount) {
        int bills = 0;
        int index = deno.length - 1;
        while (amount > 0) {
            int val = amount / deno[index];
            bills += val;
            amount %= deno[index];
            index--;
        }
        return bills;
    }

    public static void main(String args[]) {
        HittheLottery hl = new HittheLottery();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int amount = sc.nextInt();
        sb.append(hl.findMinBills(amount)).append("\n");
        System.out.println(sb.toString());
    }
}
