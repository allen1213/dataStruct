package com.example.demo.data.structure.recu;

public class Queen {

    private static int count;

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    //判断第n个皇后是否 与 前 n - 1 个皇后有冲突
    public static boolean isRight(int[] a,int n) {

        for (int i = 0; i < n; i++) {
            // 判断是否在同一列上或者是否在同一对角线上
            if (a[i] == a[n] || Math.abs(a[i] - a[n]) == Math.abs(i - n))
                return false;
        }

        return true;
    }

    public static void check(int[] a,int n) {
        //若 要拜访的第 n 个皇后刚好等于 数组长度，说明已经拜访完成
        if (n == a.length) {
            count ++;
            print(a);
            return;
        }

        //否则，循环将第n个皇后，在一行上依次摆放
        for (int i = 0; i < a.length; i++) {
            //刚开始时，第n个皇后肯定先摆放在第0个位置
            a[n] = i;
            //然后检测摆放在这个位置上是否和前n - 1 个皇后冲突
            // 若不冲突则递归放下一个皇后
            //否则，回溯 a[n]  = i
            if (isRight(a,n))
                check(a,n + 1);
        }

    }

    public static void main(String[] args) {
        int[] a = new int[8];
        check(a,0);
        System.out.println(count);
    }
}
