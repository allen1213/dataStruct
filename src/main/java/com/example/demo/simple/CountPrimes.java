package com.example.demo.simple;

public class CountPrimes {

    public static int countPrimes(int n) {

        boolean[] flag = new boolean[n];

        int count = 0;
        for (int i = 2 ; i * i < n; i ++) {
            //if (!flag[i]) flag[i] = true;
            for (int j = i * i; j < n; j += i) {
                flag[j] = true;
            }
        }
        for (int i = 2; i < n; i++) {
            if (!flag[i]) count ++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}

/**
 *
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
