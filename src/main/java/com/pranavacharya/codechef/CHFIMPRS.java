package com.pranavacharya.codechef;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class CHFIMPRS {

    public void makePalindrom(int n, int m, TreeMap<Integer, Integer> frequency) {
        if (n == 0) {
            System.out.println(-1);
            return;
        }
        LinkedList<Integer> oddValue = new LinkedList<>();
        int oddnumbers = 0;
        for (int key : frequency.keySet()) {
            if (frequency.get(key) % 2 == 1) {
                oddValue.add(key);
                oddnumbers++;
            }
        }
        if ((m % 2 == 0 && oddnumbers > 0) || (m % 2 == 1 && oddnumbers > n)) {
            System.out.println(-1);
            return;
        }
        int[][] pd = new int[n][m];
        if (m % 2 == 1) {
            int count = 0;
            while (count < oddnumbers) {
                int element = oddValue.poll();
                pd[count][m / 2] = element;
                frequency.put(element, frequency.get(element) - 1);
                if (frequency.get(element) == 0) {
                    frequency.remove(element);
                }
                count++;
            }
            while (count < n) {
                int element = frequency.firstKey();
                pd[count][m / 2] = element;
                frequency.put(element, frequency.get(element) - 1);
                if (frequency.get(element) == 0) {
                    frequency.remove(element);
                }
                count++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m / 2; j++) {
                    int element = frequency.firstKey();
                    pd[i][j] = element;
                    pd[i][m - 1 - j] = element;
                    frequency.put(element, frequency.get(element) - 2);
                    if (frequency.get(element) == 0) {
                        frequency.remove(element);
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m / 2; j++) {
                    int element = frequency.firstKey();
                    pd[i][j] = element;
                    pd[i][m - 1 - j] = element;
                    frequency.put(element, frequency.get(element) - 2);
                    if (frequency.get(element) == 0) {
                        frequency.remove(element);
                    }
                }
            }
        }
        printlnArray(pd);
    }

    public void printlnArray(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String args[]) {
        CHFIMPRS c = new CHFIMPRS();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            TreeMap<Integer, Integer> frequency = new TreeMap();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int element = sc.nextInt();
                    frequency.put(element, frequency.getOrDefault(element, 0) + 1);
                }
            }
            c.makePalindrom(n, m, frequency);
        }
    }
}
