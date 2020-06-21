package com.pranavacharya.codechef;

import java.util.Scanner;

public class CACHEHIT {

    public int cacheHit(int n, int b, int[] query) {
        int count = 0;
        Integer last = null;
        for (int q : query) {
            if (last == null || (q) / b != last) {
                last = (q) / b;
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        CACHEHIT c = new CACHEHIT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int m = sc.nextInt();
            int[] query = new int[m];
            for (int j = 0; j < query.length; j++) {
                query[j] = sc.nextInt();
            }
            sb.append(c.cacheHit(n, b, query));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
