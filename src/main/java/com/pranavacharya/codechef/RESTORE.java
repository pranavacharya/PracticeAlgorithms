package com.pranavacharya.codechef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RESTORE {

    private ArrayList<Integer> primes;

    public RESTORE() {
        this.primes = getPrimeNumbers(4000000);
    }

    public int[] restoreA(int[] arr) {
        int[] a = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap();
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                a[i] = map.get(arr[i]);
            } else {
                a[i] = primes.get(index++);
                map.put(arr[i], a[i]);
            }
        }

        return a;
    }

    private ArrayList<Integer> getPrimeNumbers(int n) {
        ArrayList<Integer> primes = new ArrayList();
        boolean[] visited = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = i; i * j <= n; j++) {
                visited[i * j] = true;
            }
        }

        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String args[]) {
        RESTORE r = new RESTORE();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            int[] ans = r.restoreA(arr);
            for (int j = 0; j < ans.length; j++) {
                sb.append(ans[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
