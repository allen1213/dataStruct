package com.example.demo.sort;

public class QuickSort {

    public static void quickSort(int[] a,int left,int right) {

        if (left < right) {
            int temp;
            int first = a[left];
            int i = left,j = right;

            while (i < j) {

                while (a[i] < first && i < right)
                    i ++;
                while (a[j] > first && j > left)
                    j --;

                if (i <= j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i ++;
                    j --;
                }

            }

            /*if (i == j) {
                i ++;
                j --;
            }*/

            quickSort(a,left,j);
            quickSort(a,i,right);

            //quickSort(a,);

        }

    }

    public static void quickSort2(int[] a,int start,int end) {

        if (start < end) {

            int base = a[start];
            int temp;
            int i = start,j = end;
            do {

                while (a[i] < base && i < end)
                    i ++;

                while (a[j] > base && j > start)
                    j --;

                /*if (i <= j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i ++;
                    j --;
                }*/

            } while (i <= j);

            /*quickSort2(a,start,j);
            quickSort2(a,i,end);*/

        }

    }

    public static void quickSort3(int[] list, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int point = partition(list, left, right);

            // 递归调用，对左子数组进行快速排序
            quickSort3(list, left, point - 1);
            // 递归调用，对右子数组进行快速排序
            quickSort3(list, point + 1, right);
            System.out.println("left : " + left + "  point : " + (point + 1) + "  right : " + right);
        }

    }

    /**
     * 分割数组，找到分割点
     */
    private static int partition(int[] list, int left, int right) {
        // 用数组的第一个元素作为基准数
        int first = list[left];
        while (left < right) {
            while (left < right && list[right] >= first) {
                right--;
            }
            // 交换
            swap(list, left, right);

            while (left < right && list[left] <= first) {
                left++;
            }
            // 交换
            swap(list, left, right);
        }
        // 返回分割点所在的位置
        return left;
    }

    /**
     * 交换数组中两个位置的元素
     */
    private static void swap(int[] list, int left, int right) {
        int temp;
        if (list != null && list.length > 0) {
            temp = list[left];
            list[left] = list[right];
            list[right] = temp;
        }
    }

    public static void main(String[] args) {

        //6,1,2,7,9,3,4,5,10,8  32,43,23,13,5
        int[] a = {6,1,2,7,9,3,4,5,10,8};

        quickSort(a,0,a.length - 1);
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
