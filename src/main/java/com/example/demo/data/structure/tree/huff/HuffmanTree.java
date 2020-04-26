package com.example.demo.data.structure.tree.huff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static Node createHuffmanTree(int[] arr) {

        List<Node> nodeList = new ArrayList<>();
        for (int i : arr) nodeList.add(new Node(i));
        //排序
        Collections.sort(nodeList);

        while (nodeList.size() > 1) {
            Node left = nodeList.get(0);
            Node right = nodeList.get(1);

            Node parent = new Node(left.getValue() + right.getValue());
            parent.setLeft(left).setRight(right);

            nodeList.remove(left);
            nodeList.remove(right);

            nodeList.add(parent);

            Collections.sort(nodeList);
        }

        return nodeList.get(0);

    }

    public static void preOrder(Node root) {
        if (root == null)  return;
        root.preOrder();
    }

}

class Node implements Comparable<Node>{

    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public Node setValue(int value) {
        this.value = value;
        return this;
    }

    public Node getLeft() {
        return left;
    }

    public Node setLeft(Node left) {
        this.left = left;
        return this;
    }

    public Node getRight() {
        return right;
    }

    public Node setRight(Node right) {
        this.right = right;
        return this;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) this.left.preOrder();
        if (this.right != null) this.right.preOrder();
    }

}
