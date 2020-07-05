package com.pranavacharya.atcoder;

import java.util.HashMap;
import java.util.Scanner;

public class JudgeStatusSummary {

    public void countFrequency(String[] verdict) {
        HashMap<String, Integer> frequency = new HashMap();
        String[] key = new String[]{"AC", "WA", "TLE", "RE"};
        for (String v : verdict) {
            frequency.put(v, frequency.getOrDefault(v, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String k : key) {
            if (frequency.containsKey(k)) {
                sb.append(k).append(" x ").append(frequency.get(k)).append("\n");
            } else {
                sb.append(k).append(" x ").append(0).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String args[]) {
        JudgeStatusSummary jss = new JudgeStatusSummary();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
        jss.countFrequency(arr);
    }
}
