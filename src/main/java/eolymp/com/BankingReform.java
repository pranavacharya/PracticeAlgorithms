package eolymp.com;

import java.util.Scanner;

public class BankingReform {

    public int findCombination(int n) {
        int[] coins = new int[]{1, 5, 10, 25, 50};
        int[][] dp = new int[coins.length][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (coins[i] == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                if (coins[i] == j) {
                    dp[i][j]++;
                }
                if (j - coins[i] >= 0) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String args[]) {
        BankingReform br = new BankingReform();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextInt()) {
            int total = sc.nextInt();
            sb.append(br.findCombination(total)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
