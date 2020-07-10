package com.pranavacharya.codechef;

import java.util.Scanner;
import java.util.Stack;

public class COMPILER {

    public int findValidLength(String ip) {
        int length = 0;
        int temp = 0;
        Stack<Character> stack = new Stack();
        char[] iparr = ip.toCharArray();
        for (char i : iparr) {
            if (i == '<') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && stack.peek() == '<') {
                    stack.pop();
                    temp += 2;
                    if (stack.isEmpty()) {
                        length += temp;
                        temp = 0;
                    }
                } else {
                    return length;
                }
            }
        }
        return length;
    }

    public static void main(String args[]) {
        COMPILER c = new COMPILER();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String ip = sc.next();
            sb.append(c.findValidLength(ip)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
