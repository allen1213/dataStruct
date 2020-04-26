package com.example.demo.data.structure;

import java.util.Queue;
import java.util.Scanner;

/**
 * 使用数组模拟队列
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {


        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("list");
            System.out.println("exit");
            System.out.println("add");
            System.out.println("get");
            System.out.println("head");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'l':
                    System.out.println("queue : ");
                    queue.list();
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                case 'a':
                    System.out.print("please input a number : ");
                    queue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        System.out.println(queue.popQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(queue.peek());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;

            }
        }

    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue is full !");
            return;
        }
        arr[++rear] = n;
    }

    public int popQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty !");
        }
        return arr[++front];
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            return;
        }
        for (int i = front + 1; i <= rear; i ++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty !");
        }
        return arr[front + 1];
    }

}
