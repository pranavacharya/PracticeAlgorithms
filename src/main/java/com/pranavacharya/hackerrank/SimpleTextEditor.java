package com.pranavacharya.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    private class Command {

        int command;
        String val;
        int length;

        public Command(int c, String val, int length) {
            this.command = c;
            this.val = val;
            this.length = length;
        }
    }

    private StringBuilder sb;
    private Stack<Command> stack;

    public SimpleTextEditor() {
        this.sb = new StringBuilder();
        this.stack = new Stack();
    }

    private void append(String input) {
        this.sb.append(input);
        int len = input.length();
        this.stack.push(new Command(2, "", len));
    }

    private void delete(int k) {
        String deleted = this.sb.substring(sb.length() - k, sb.length());
        this.sb.delete(sb.length() - k, sb.length());
        this.stack.push(new Command(1, deleted, 0));
    }

    private char print(int k) {
        return this.sb.charAt(k - 1);
    }

    private void undo() {
        Command last = stack.pop();
        switch (last.command) {
            case 1:
                this.sb.append(last.val);
                break;
            case 2:
                this.sb.delete(sb.length() - last.length, sb.length());
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void main(String args[]) {
        SimpleTextEditor ste = new SimpleTextEditor();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    String input = sc.nextLine().trim();
                    ste.append(input);
                    break;
                case 2:
                    int len = sc.nextInt();
                    ste.delete(len);
                    break;
                case 3:
                    int k = sc.nextInt();
                    System.out.println(ste.print(k));
                    break;
                case 4:
                    ste.undo();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
