package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class Corus {

    public void queueLength(String S, int[] numOfCenter) {
        HashMap<Character, Integer> frequency = new HashMap();
        for (int i = 0; i < S.length(); i++) {
            frequency.put(S.charAt(i), frequency.getOrDefault(S.charAt(i), 0) + 1);
        }
        for (int c : numOfCenter) {
            int queueLen = 0;
            for (char virus : frequency.keySet()) {
                if (frequency.get(virus) > c) {
                    queueLen += (frequency.get(virus) - c);
                }
            }
            System.out.println(queueLen);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Corus ic = new Corus();
        int testcases = sc.nextInt();
        for (int i = 1; i <= testcases; i++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            String S = sc.next();
            int[] numOfCenter = new int[Q];
            for (int j = 0; j < Q; j++) {
                numOfCenter[j] = sc.nextInt();
            }
            ic.queueLength(S, numOfCenter);
        }
    }
}
