package com.example.demo.data.structure;

public class SingleLinkListDemo {

    public static void main(String[] args) {
        Node bobo = new Node(1, "bobo", "bobo");
        Node boer = new Node(2, "boer", "boer");
        Node may = new Node(3,"may", "may");
        Node park = new Node(4, "park", "park");

        SingleLinkList linkList = new SingleLinkList();
        //linkList.addNodeByOrder(bobo);
        linkList.addNodeByOrder(bobo);
        linkList.addNodeByOrder(boer);
        linkList.addNodeByOrder(park);
        linkList.addNodeByOrder(may);
        //linkList.addNodeByOrder(may);
        //linkList.addNodeByOrder(may);
        //linkList.list();

        /*linkList.updateByNodeNo(new Node(3, "MayJ", "MayJ"));
        System.out.println();
        linkList.list();*/

        /*System.out.println();
        linkList.deleteByNodeNo(new Node(3, "parkO", "parkO"));
        linkList.deleteByNodeNo(new Node(1, "parkO", "parkO"));
        linkList.list();*/

        linkList.reverseList(linkList.getHead());
        linkList.list();


    }
}

class Node {

    public int no;
    public String name;
    public String nickName;
    public Node next;

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}

class SingleLinkList {
    private Node head = new Node(0,"","");

    public Node getHead() {
        return head;
    }

    public void addNode(Node node) {
        //头结点不能动，因此需要一个辅助变量
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                break;
            }
            //若没到末尾，则temp后移
            temp = temp.next;

        }
    }

    public void addNodeByOrder(Node node) {

        Node temp = head;

        while (true) {

            if (temp.next == null || (temp.next != null && temp.next.no > node.no)) {
                node.next = temp.next;
                temp.next = node;
                break;
            }

            if (temp.next != null && temp.next.no == node.no) {
                System.out.println("node is exits!");
                break;
            }

            temp = temp.next;

        }

        //是否可添加
        /*boolean flag = true;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = false;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            node.next = temp.next;
            temp.next = node;
        } else {
            System.out.println("node is exits!");
        }
*/
    }

    public void list() {
        //判断链表是否为空
        if (head.next == null) return;

        Node temp = head.next;
        while (true) {
            if (temp == null) break;
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public boolean updateByNodeNo(Node node) {
        if (head.next == null) return false;
        Node temp = head;
        while (true) {

            if (temp == null) return false;

            if (temp.no == node.no) {
                temp.name = node.name;
                temp.nickName = node.nickName;
                return true;
            }

            temp = temp.next;

        }
    }

    public boolean deleteByNodeNo(Node node) {

        if (head.next == null) return false;

        Node temp = head;
        while (true) {

            if (temp.next == null) return false;

            if (temp.next.no == node.no) {
                temp.next = temp.next.next;
                return true;
            }

            temp = temp.next;

        }

    }

    public int size() {
        if (head.next == null) return 0;
        Node temp = head.next;

        int size = 0;
        while (temp != null) {
            size ++;
            temp = temp.next;
        }

        return size;
    }

    public void reverseList(Node head) {
        if (head.next == null || head.next.next == null) return;

        //辅助变量
        Node curr = head.next;
        //记录辅助变量的下一个结点
        Node next;
        Node reverseHead = new Node(0,"","");

        while (curr != null) {

            next = curr.next;

            curr.next = reverseHead.next;

            reverseHead.next = curr;

            curr = next;

        }

        head.next = reverseHead.next;

    }

}
