/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pranavacharya.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author pranav
 */
public class ArrivingatBloomington {

    private int findDistance(int n, int[] arr) {
        int dis = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = arr[0]; i <= arr[n - 1]; i++) {
            int lucy = i;
            int local = 0;
            for (int j = 0; j < n; j++) {
                local += Math.abs(lucy - arr[j]);
            }
            if (local < dis) {
                dis = local;
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        ArrivingatBloomington ab = new ArrivingatBloomington();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            sb.append(ab.findDistance(n, arr)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
