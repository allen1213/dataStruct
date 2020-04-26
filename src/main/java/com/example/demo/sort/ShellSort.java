package com.example.demo.sort;

public class ShellSort {

    public static int[] shellSort(int[] a) {

        //首先定义 步长gap
        int gap = a.length / 2;
        while (gap > 0) {
            for (int i = gap;i < a.length;i ++) {
                //记录有序序列的最后一个元素的下标
                int j = i - gap;
                //记录要插入的数据
                int temp = a[i];
                //从有序序列的最后一个元素开始往前遍历
                for (;j >= 0 && a[j] > temp; j -= gap) {
                    a[j + gap] = a[j];
                }
                a[j + gap] = temp;
            }
            gap /= 2;
        }
        return a;
    }


    public static void main(String[] args) {

        int[] a = {12,7,36,13,56,29,41};
        shellSort(a);

        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

}
