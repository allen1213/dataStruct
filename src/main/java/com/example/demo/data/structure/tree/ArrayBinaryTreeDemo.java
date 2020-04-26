package com.example.demo.data.structure.tree;

public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree binaryTree = new ArrayBinaryTree(arr);
        binaryTree.preOrder(0);

    }
}

class ArrayBinaryTree {
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) return;

        System.out.println(arr[index]);

        if ((index * 2 + 1) < arr.length)
            preOrder(index * 2 + 1);
        if ((index * 2 + 2) < arr.length)
            preOrder(index * 2 + 2);
    }
}
