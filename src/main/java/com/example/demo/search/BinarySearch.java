package com.example.demo.search;

public class BinarySearch {

    public static int binarySearch(int[] arr,int val) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] > val)
                right = mid - 1;
            else if (arr[mid] < val)
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 5));
    }

}
