package com.example.demo.data.structure.stack;

import java.util.Stack;

public class Calculator {


    public static int calculate(String str) {

        Stack<String> numStack = new Stack<>();
        Stack<String> charStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                numStack.push(String.valueOf(c));
            } else {

                if (charStack.empty() || compare(charStack.peek()) >= compare(String.valueOf(c))) {
                    charStack.push(String.valueOf(c));
                } else {
                    int n1 = Integer.parseInt(numStack.pop());
                    int n2 = Integer.parseInt(numStack.pop());
                    int result = cal(n2,n1,charStack.pop().charAt(0));

                    numStack.push(String.valueOf(result));
                    charStack.push(String.valueOf(c));

                }

            }

        }

        while (!charStack.empty()) {

            char c = charStack.pop().charAt(0);
            int n1 = Integer.parseInt(numStack.pop());
            int n2 = Integer.parseInt(numStack.pop());

            int result = cal(n2,n1,c);
            numStack.push(String.valueOf(result));

        }

        return Integer.parseInt(numStack.pop());
    }

    private static int cal(int n1, int n2, char c) {
        if (c == '+') return n1 + n2;
        if (c == '-') return n1 - n2;
        if (c == '*') return n1 * n2;
        if (c == '/') return  n1 / n2;
        return 0;
    }

    public static int compare(String s) {
        if ("+".equals(s) || "-".equals(s)) return 1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(calculate("7-1*2+9/3"));
    }


}
