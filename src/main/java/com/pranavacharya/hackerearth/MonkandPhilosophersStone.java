package com.pranavacharya.hackerearth;

import java.util.Scanner;
import java.util.Stack;

public class MonkandPhilosophersStone {

    public int findBagSize(int[] coins, int x, String[] instructions) {
        Stack<Integer> bag = new Stack();
        int worth = 0;
        int coinIndex = 0;
        for (String i : instructions) {
            if (i.equals("Harry")) {
                bag.push(coins[coinIndex]);
                worth += coins[coinIndex++];
            } else {
                worth -= bag.pop();
            }

            if (worth == x) {
                return bag.size();
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        MonkandPhilosophersStone mps = new MonkandPhilosophersStone();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int instructionSize = sc.nextInt();
        String[] instructions = new String[instructionSize];
        int x = sc.nextInt();
        for (int i = 0; i < instructionSize; i++) {
            instructions[i] = sc.next();
        }
        System.out.println(mps.findBagSize(coins, x, instructions));
    }
}
