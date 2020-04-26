package com.example.demo.data.structure;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        CircleArrayQueue queue = new CircleArrayQueue(4);
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

class CircleArrayQueue {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("Queue is full !");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int popQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty !");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("Queue is empty !");
            return;
        }
        for (int i = front; i < front + size(); i ++) {
            System.out.print("arr["+(i % maxSize)+"]" + " = "+arr[i % maxSize] + "\t");
        }
        System.out.println();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty !");
        }
        return arr[front];
    }


}
