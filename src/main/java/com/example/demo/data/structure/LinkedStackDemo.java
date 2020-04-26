package com.example.demo.data.structure;

public class LinkedStackDemo {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.addNode(5);
        linkedList.list();
        System.out.println(linkedList.size());

        INode node = linkedList.deleteNode();
        System.out.println(node.getValue());
        linkedList.list();
        System.out.println(linkedList.size());
    }
}

class LinkedStack {

    private int maxSize;

    private LinkedList list;

    private int top = -1;

    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
        list = new LinkedList();
        //list.addNode(maxSize);
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) return;
        top ++;
        list.addNodeStack(value);
    }

    public int pop() {
        if (isEmpty()) return -1;


        list.deleteNode();
        return 1;
    }

}

class LinkedList {
    private INode head = new INode(-1);

    public void addNode(int nums) {
        INode temp = head;
        for (int i = 1; i <= nums; i++) {
            INode node = new INode(i);
            temp.setNext(node);
            temp = node;
        }
    }

    public void addNodeStack(int value) {
        INode temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(new INode(value));
                break;
            }
            temp = temp.getNext();
        }
    }

    public void deleteNode(int n) {
        if (head.getNext() == null) return;
        INode temp = head;
        while (true) {
            if (temp.getNext() == null) break;

            if (temp.getNext().getValue() == n) {
                temp.setNext(temp.getNext().getNext());
                break;
            }

            temp = temp.getNext();
        }
    }

    public INode deleteNode() {
        if (head.getNext() == null) return null;
        INode temp = head;
        INode res;
        while (true) {
            if (temp.getNext() != null && temp.getNext().getNext() == null) {
                res = temp.getNext().getNext();
                temp.setNext(null);
                break;
            }
            temp = temp.getNext();
        }
        return res;
    }

    public int size() {
        INode temp = head;
        int count = 0;
        while (true) {
            if (temp.getNext() == null) break;
            temp = temp.getNext();
            count ++;
        }
        return count;
    }

    public void list() {
        if (head.getNext() == null) return;

        INode temp = head.getNext();
        while (true) {
            System.out.print(temp.getValue() + "  ");
            if (temp.getNext() == null) break;
            temp = temp.getNext();
        }
        System.out.println();
    }

}

class INode {
    private int value;
    private INode next;

    public INode() {}

    public INode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public INode setValue(int value) {
        this.value = value;
        return this;
    }

    public INode getNext() {
        return next;
    }

    public INode setNext(INode next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "INode{" +
                "value=" + value +
                '}';
    }
}
