package com.example.demo.data.structure.cricle.linked;

public class Josephus {

    public static void main(String[] args) {
        CircleSingleLinkedList linkedList = new CircleSingleLinkedList();

        linkedList.addNode(5);
        linkedList.list();

        linkedList.count(1,2,5);
    }
}

class Node{
    public int no;
    public Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}

class CircleSingleLinkedList {
    private Node first;

    public void addNode(int nums) {
        if (nums < 1) return;

        Node temp = null;
        for (int i = 1; i <= nums; i++) {

            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.next = first;
                temp = first;
            }

            temp.next = node;
            node.next = first;

            temp = temp.next;

        }
    }

    public void list() {

        if (first == null) return;

        Node temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.next == first) break;
            temp = temp.next;
        }

    }

    /**
     *
     * @param start  从第几个开始数
     * @param countNum  数几个数
     * @param num  刚开始的时候有多少个数
     */
    public void count(int start,int countNum,int num) {
        if (first == null || start < 1 || start > num) return;

        //helper 指向环形链表的最后一个节点
        Node helper = first;
        while (true) {
            if (helper.next == first) break;
            helper = helper.next;
        }

        //从队列的第几个节点开始，first节点和 helper节点都要移动到指定的位置
        /*while (true) {
            if (s)
            first = first.next;
            helper = helper.next;
        }*/

        while (true) {

            if (helper == first) {
                System.out.println(helper.no);
                return;
            }

            for (int i = 1; i < countNum ; i++) {
                first = first.next;
                helper = helper.next;
            }

            System.out.print(first.no + " -> ");

            first = first.next;
            helper.next = first;

        }

    }
}
