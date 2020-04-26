package com.example.demo.practice;

public class Sort {

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

    //插入排序
    public static void insertSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            /*for (;j >= 0 && a[j] > temp;j --) {
                a[j+1] = a[j];
            }*/
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }

    }

    //希尔排序
    public static void shellSort(int[] a) {
        int gap = a.length / 2;
        while (gap > 0) {

            for (int i = gap; i < a.length; i++) {

                int temp = a[i];
                int j = i - gap;
                /*for (;j >= 0 && a[j] > temp; j -= gap) {
                    a[j+gap] = a[j];
                }*/
                while (j >= 0 && a[j] > temp) {
                    a[j + gap] = a[j];
                    j -= gap;
                }
                a[j + gap] = temp;
            }

            gap /= 2;
        }
    }

    //选择排序
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int pos = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    pos = j;
                }
            }
            a[pos] = a[i];
            a[i] = temp;

        }
    }

    //堆排序
    public static void heapSort(int[] a) {}

    //冒泡排序
    public static void bubbleSort(int[] a) {
        boolean flag = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i -1; j++) {
                if (a[j] > a[j+1]) {
                    flag = false;
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            if (flag) break;
            else flag = true;
        }
    }

    //快速排序-递归
    public static void quickSort(int[] a, int left, int right) {

        if (left < right) {

            int temp;
            int first = a[left];
            int i = left, j = right;

            while (i < j) {

                while (first > a[i])
                    i++;
                while (first < a[j])
                    j--;

                if (i <= j) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                    j--;
                }

            }
            quickSort(a, left, j);
            quickSort(a, i, right);
        }
    }

    //归并排序
    private static void merge(int[] a,int left,int mid,int right,int[] temp) {

        int i = left;
        int j = mid + 1;

        int k = 0;
        while (i <= mid && j <= right) {

            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= mid)
            temp[k++] = a[i++];

        while (j <= right)
            temp[k++] = a[j++];

        k = 0;
        while (left <= right)
            a[left++] = temp[k++];

    }

    public static void mergeSort(int[] a,int left,int right,int[] temp) {

        int mid = (left + right) / 2;
        if (left < right) {

            mergeSort(a,left,mid,temp);

            mergeSort(a,mid + 1,right,temp);

            merge(a,left,mid,right,temp);

        }

    }

    //基数排序
    public static void radixSort(int[] a) {

        //获取数组中最大的值
        int max = a[0];
        for (int i : a) {
            if (i > max) max = i;
        }

        //获取最大值的长度
        int length = (Math.abs(max) + "").length();

        //bucket[][]  行表示第几个桶，行+列 表示存放的元素
        int[][] bucket = new int[10][a.length];

        //count[]  表示第n个桶中总共有多少个元素
        int[] count = new int[10];


        for (int i = 0,n = 1; i < length; i++, n *= 10) {

            //遍历数组，依次取出数组中元素的个十百千...未，然后将位数分别放到不同的桶中，且对应的桶中个数++
            for (int j = 0; j < a.length; j++) {

                //得到a[j]   要放入的 桶号
                int num = a[j] / n % 10;

                //将a[j]   要放入对应的 桶号中,并且对应桶中元素的个数也要++
                bucket[num][count[num] ++] = a[j];
            }

            int index = 0; //因为每次基数排序都是要把所有的元素都放回到数组中的，所以每次都要从0开始

            //将数据都放到桶之后，在从桶中将数据按顺序放回数组中,每次放完记得要清空count的个数！！！
            for (int j = 0; j < bucket.length; j++) {
                //若某个桶中元素的个数为0 ，那么这个桶就不用遍历了
                if (count[j] != 0) {
                    //桶中元素不为0，则将桶中的元素放回数组中,
                    //遍历桶中的元素，count[j] 中存放的就是 第j个桶中元素的个数
                    for (int k = 0; k < count[j]; k++) {
                        a[index ++] = bucket[j][k];
                    }
                    //每当把桶中元素放完回数组中时，要将改桶的count 清零，以便下一次排序时统计元素数量
                    count[j] = 0;
                }
            }

        }


    }

    public static void main(String[] args) {
        //6, 1, 2, 7, 9, 3, 4, 5, 10, 8
        int[] a = new int[10];
        initArray(a);
        //mergeSort(a,0,a.length - 1,new int[a.length]);
        radixSort(a);
        print(a);
    }

}
