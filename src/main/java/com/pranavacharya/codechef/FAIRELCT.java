package com.pranavacharya.codechef;

import java.util.Arrays;
import java.util.Scanner;

public class FAIRELCT {

    public int findMinSwaps(int[] nPack, int[] mPack) {
        int nSum = 0;
        int mSum = 0;
        for (int i = 0; i < nPack.length; i++) {
            nSum += nPack[i];
        }
        for (int i = 0; i < mPack.length; i++) {
            mSum += mPack[i];
        }
        Arrays.sort(nPack);
        Arrays.sort(mPack);
        int swaps = 0;
        int i = 0;
        int j = mPack.length - 1;
        while (i < nPack.length && j >= 0 && nSum <= mSum) {
            nSum -= nPack[i];
            nSum += mPack[j];
            mSum -= mPack[j];
            mSum += nPack[i];
            i++;
            j--;
            swaps++;
        }
        if (nSum <= mSum) {
            return -1;
        }
        return swaps;
    }

    public static void main(String args[]) {
        FAIRELCT f = new FAIRELCT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nPack = new int[n];
            int m = sc.nextInt();
            int[] mPack = new int[m];
            for (int j = 0; j < n; j++) {
                nPack[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                mPack[j] = sc.nextInt();
            }
            sb.append(f.findMinSwaps(nPack, mPack)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
