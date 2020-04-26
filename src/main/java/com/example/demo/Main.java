package com.example.demo;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static int countPrimes(int n) {
return 0;

    }

    public static void reversArray(int[] nums) {

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[i];
            nums[i] = temp;
        }

        for (int num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15,0,4};

        System.out.println(countPrimes(15));
        reversArray(nums);

    }
}
