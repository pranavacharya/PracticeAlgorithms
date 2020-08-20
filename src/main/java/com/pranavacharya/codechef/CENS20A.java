package com.pranavacharya.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CENS20A {

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n + 1][m + 1];
        int[][] da = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= n; i++) {
            String line = sc.next();
            int j = 1;
            for (char ch : line.toCharArray()) {
                matrix[i][j++] = ch - '0';
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            da[x1][y1]++;
            da[x2 + 1][y2 + 1]++;
            da[x2 + 1][y1]--;
            da[x1][y2 + 1]--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                da[i][j] += da[i - 1][j] + da[i][j - 1] - da[i - 1][j - 1];
                if (da[i][j] % 2 == 0) {
                    sb.append(matrix[i][j]);
                } else {
                    if (matrix[i][j] == 1) {
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
