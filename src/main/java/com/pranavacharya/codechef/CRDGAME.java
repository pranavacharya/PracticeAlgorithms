package com.pranavacharya.codechef;

import java.util.Scanner;

public class CRDGAME {

    public int[] findWinner(int[][] cards) {
        int cScore = 0;
        int mScore = 0;

        for (int[] hand : cards) {
            int cHand = findSum(hand[0]);
            int mHand = findSum(hand[1]);
            if (cHand > mHand) {
                cScore++;
            } else if (mHand > cHand) {
                mScore++;
            } else {
                cScore++;
                mScore++;
            }
        }
        if (cScore == mScore) {
            return new int[]{2, cScore};
        } else if (cScore > mScore) {
            return new int[]{0, cScore};
        } else {
            return new int[]{1, mScore};
        }
    }

    public int findSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String args[]) {
        CRDGAME c = new CRDGAME();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] cards = new int[n][2];
            for (int j = 0; j < cards.length; j++) {
                cards[j][0] = sc.nextInt();
                cards[j][1] = sc.nextInt();
            }
            int[] ans = c.findWinner(cards);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
