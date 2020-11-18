package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class ADADISH {

    public int findMinTime(int[] dishes) {
        int burner1 = 0;
        int burner2 = 0;
        Arrays.sort(dishes);
        for (int i = dishes.length - 1; i >= 0; i--) {
            int dish = dishes[i];
            if (burner1 < burner2) {
                burner1 += dish;
            } else {
                burner2 += dish;
            }
        }
        return Math.max(burner1, burner2);
    }

    public static void main(String args[]) {
        ADADISH s = new ADADISH();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] dishes = new int[n];
            for (int j = 0; j < n; j++) {
                dishes[j] = sc.nextInt();
            }
            sb.append(s.findMinTime(dishes)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
