package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHNUM {

    public void groupSize(int[] nums) {
        int neg = 0;
        int pos = 0;
        int zero = 0;
        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num > 0) {
                pos++;
            } else {
                zero++;
            }
        }

        int min = Math.min(pos, neg);
        int max = Math.max(pos, neg);
        max = max + zero;
        min = min == 0 ? max : min;
        System.out.format("%d %d", max, min);
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        CHNUM cn = new CHNUM();
        int testcases = sc.nextInt();
        for (int i = 1; i <= testcases; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }
            cn.groupSize(nums);
        }
    }

}
