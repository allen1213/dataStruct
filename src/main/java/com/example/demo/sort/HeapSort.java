package com.example.demo.sort;

public class HeapSort {

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    private static void initArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 1200);
        }
    }

    private static void buildHeap(int[] arr) {}

    public static void heapSort(int[] arr) {}

    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        print(arr);
    }
}
