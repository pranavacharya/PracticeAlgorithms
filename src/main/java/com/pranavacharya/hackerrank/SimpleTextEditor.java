package com.pranavacharya.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<String> stack = new Stack();
        String str = "";
        stack.push(str);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    String input = sc.nextLine().trim();
                    str += input;
                    stack.push(str);
                    break;
                case 2:
                    int len = sc.nextInt();
                    String deleted = str.substring(0, str.length() - len);
                    str = deleted;
                    stack.push(deleted);
                    break;
                case 3:
                    int k = sc.nextInt();
                    sb.append(str.charAt(k - 1)).append("\n");
                    break;
                case 4:
                    stack.pop();
                    str = stack.peek();
                    break;
                default:
                    throw new AssertionError();
            }
        }
        System.out.println(sb.toString());
    }
}
