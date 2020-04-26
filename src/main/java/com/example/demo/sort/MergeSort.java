package com.example.demo.sort;

public class MergeSort {

    public static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr,left,mid,temp);

            mergeSort(arr,mid + 1,right,temp);

            merge(arr,left,mid,right,temp);

        }
    }

    /**
     *  合并
     * @param arr  要合并的数组
     * @param left  从哪个位置开始
     * @param mid  中间位置
     * @param right  结束位置
     * @param temp 临时数组，暂时存放数据，最后将数据依次复制到arr中
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp) {

        int i = left;
        int j = mid + 1;

        int k = 0;//记录temp下标的值

        //首先依次从left 和 mid 两个位置开始 分别比较 元素的值，将值存放到temp数组中
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //然后依次判断左右两边是否已经将值都复制到temp里
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        //最后将temp的值copy到arr中，这里并不是将整个数组全部复制，而是复制
        k = 0;
        while (left <= right)
            arr[left++] = temp[k++];


    }


    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        mergeSort(arr,0,arr.length - 1,new int[arr.length]);
        print(arr);
    }
}
