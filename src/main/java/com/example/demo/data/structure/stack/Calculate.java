package com.example.demo.data.structure.stack;

import java.util.Stack;

public class Calculate {

    public static int priority(int n) {
        if (n == '*' || n == '/') return 1;
        return 0;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static int cal(int n1, int n2, char c) {
        if (c == '+') return n1 + n2;
        if (c == '-') return n1 - n2;
        if (c == '*') return n1 * n2;
        if (c == '/') return  n1 / n2;
        return 0;
    }

    public static int calculate(String str) {

        Stack<String> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

            if (!isNum(c)) {

                if (!charStack.empty() && priority(c) <= priority(charStack.peek().charAt(0))) {

                    int n1 = Integer.parseInt(numStack.pop());
                    int n2 = Integer.parseInt(numStack.pop());

                    int res = cal(n2, n1, charStack.pop().charAt(0));

                    numStack.push(String.valueOf(res));
                    charStack.push(String.valueOf(c));

                } else {
                    charStack.push(String.valueOf(c));
                }

            }

        }


        return Integer.parseInt(numStack.pop());
    }

    public static void main(String[] args) {
    }
}
