package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RegExPatternsandIntrotoDatabases {

    private String printAlpha(String[] arr) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            String[] user = arr[i].split(" ");
            String username = user[0];
            String email = user[1];
            String domain = email.split("@")[1];
            if (domain.equals("gmail.com")) {
                list.add(username);
            }
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        RegExPatternsandIntrotoDatabases reg = new RegExPatternsandIntrotoDatabases();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(reg.printAlpha(arr));
    }
}
