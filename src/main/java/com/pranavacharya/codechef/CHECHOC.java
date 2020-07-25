package com.pranavacharya.codechef;

import java.util.Scanner;

public class CHECHOC {

    public long findArea(long N, long M, long X, long Y) {
        long og = X;
        if (Y < X) {
            X = Y;
        }
        long diff = (Y - X) > X ? X : (Y - X);
        if (M < N) {
            long temp = N;
            N = M;
            M = temp;
        }
        if (M == 1 && N == 1) {
            return og;
        }
        if (M % 2 == 0) {
            long row = ((M / 2) * X) + ((M / 2) * diff);
            return row * N;
        } else {
            M = M - 1;
            long row = (((M) / 2) * X) + (((M) / 2) * diff);
            long square = row * N;
            long edge = 0;
            if (N % M == 0) {
                edge = row * (N / M);
            } else {
                long small = diff * (N / 2);
                long big = X * (N - (N / 2));
                edge = (big + small);
            }
            return square + edge;
        }
    }

    public static void main(String args[]) {
        CHECHOC c = new CHECHOC();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long t = sc.nextInt();
        for (long i = 0; i < t; i++) {
            long N = sc.nextLong();
            long M = sc.nextLong();
            long X = sc.nextLong();
            long Y = sc.nextLong();
            sb.append(c.findArea(N, M, X, Y)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
