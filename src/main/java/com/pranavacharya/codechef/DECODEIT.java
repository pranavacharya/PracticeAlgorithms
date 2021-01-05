package com.pranavacharya.codechef;

import java.util.HashMap;
import java.util.Scanner;

public class DECODEIT {

    private HashMap<String, Character> map;

    public DECODEIT() {
        this.map = new HashMap();
        char c = 'a';
        for (int i = 0; i < 16; i++, c++) {
            map.put(String.format("%4s", Integer.toBinaryString(i)).replaceAll(" ", "0"), c);
        }
    }

    public String decode(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i = i + 4) {
            sb.append(this.map.get(s.substring(i, i + 4)));
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        DECODEIT decode = new DECODEIT();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String s = sc.next();
            sb.append(decode.decode(s)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
