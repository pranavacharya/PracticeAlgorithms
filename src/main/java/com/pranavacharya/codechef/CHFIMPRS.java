package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.PriorityQueue;

public class CHFIMPRS {

    public void makePalindrom(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println(-1);
            return;
        }
        HashMap<Integer, Integer> frequency = new HashMap();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (frequency.get(b) - frequency.get(a)));
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                frequency.put(matrix[j][k], frequency.getOrDefault(matrix[j][k], 0) + 1);
            }
        }
        for (int key : frequency.keySet()) {
            maxHeap.add(key);
        }
        int[][] pd = new int[matrix.length][matrix[0].length];
        if (pd[0].length % 2 == 0) {//even
            int mostFrequent = maxHeap.remove();
            for (int i = 0; i < pd.length; i++) {
                for (int j = 0; j < pd[i].length / 2; j++) {
                    if (frequency.get(mostFrequent) < 2) {
                        System.out.println(-1);
                        return;
                    }
                    pd[i][j] = mostFrequent;
                    pd[i][pd[i].length - 1 - j] = mostFrequent;
                    frequency.put(mostFrequent, frequency.get(mostFrequent) - 2);
                    if (frequency.get(mostFrequent) < 2) {
                        maxHeap.add(mostFrequent);
                        mostFrequent = maxHeap.remove();
                    }
                }
            }
            printlnArray(pd);
        } else { //odd
            int mostFrequent = maxHeap.remove();
            for (int i = 0; i < pd.length; i++) {
                for (int j = 0; j < pd[i].length / 2; j++) {
                    if (frequency.get(mostFrequent) < 2) {
                        System.out.println(-1);
                        return;
                    }
                    pd[i][j] = mostFrequent;
                    pd[i][pd[i].length - 1 - j] = mostFrequent;
                    frequency.put(mostFrequent, frequency.get(mostFrequent) - 2);
                    if (frequency.get(mostFrequent) < 2) {
                        maxHeap.add(mostFrequent);
                        mostFrequent = maxHeap.remove();
                    }
                }
            }
            for (int i = 0; i < pd.length;) {
                if (frequency.get(mostFrequent) > 0) {
                    pd[i][pd[0].length / 2] = mostFrequent;
                    frequency.put(mostFrequent, frequency.get(mostFrequent) - 1);
                    i++;
                } else {
                    mostFrequent = maxHeap.remove();
                }
            }
            printlnArray(pd);
        }

    }

    public void printlnArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        CHFIMPRS c = new CHFIMPRS();
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int[][] arr = new int[n][m];
//            for (int j = 0; j < n; j++) {
//                for (int k = 0; k < m; k++) {
//                    arr[j][k] = sc.nextInt();
//                }
//            }
//            c.makePalindrom(arr);
//        }
        c.makePalindrom(new int[][]{{2, 3, 5, 7, 3}, {4, 2, 5, 6, 4}, {3, 5, 6, 7, 3}});
    }
}
