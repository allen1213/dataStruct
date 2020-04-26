package com.example.demo.data.structure;

public class ArrayStackDemo {

    public static void main(String[] args) {
        int maxSize = 5;
        ArrayStack stack = new ArrayStack(maxSize);

        for (int i = 1; i <= maxSize; i++) {
            stack.push(i);
        }

        stack.list();

        for (int i = 1; i <= maxSize; i++) {
            System.out.println(stack.pop());
        }


    }

}


class ArrayStack {
    //栈的大小
    private int maxSize;

    private int[] stack;

    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }


    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {

        if (isFull()) return;

        stack[++top] = value;

    }

    public int pop() {
        if (isEmpty()) return -1;
        /*int value = stack[top];
        top --;*/
        return stack[top--];
    }

    public void  list() {
        if (isEmpty()) return;
        //从栈顶开始打印
        for (int i = top; i >=  0; i--) {
            System.out.print(stack[i] + "  ");
        }
        System.out.println();
    }

}