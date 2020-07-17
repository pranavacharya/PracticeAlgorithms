package com.pranavacharya.hackerrank;

import java.util.Stack;

public class BalancedBrackets {

    public String isBalanced(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '{' || arr[i] == '[') {
                stack.push(arr[i]);
            } else {
                if (stack.isEmpty() || (arr[i] == ')' && stack.peek() != '(') || (arr[i] == '}' && stack.peek() != '{')
                        || (arr[i] == ']' && stack.peek() != '[')) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String args[]) {
        BalancedBrackets bb = new BalancedBrackets();
        String input = "{[()]}";
        System.out.println(bb.isBalanced(input));
    }
}
