package com.example.demo.simple;

import java.util.Arrays;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        char[] c = s.toCharArray();
        char[] h = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(h);

        return Arrays.equals(c,h);

    }

    /*public int[] intersection(int[] nums1, int[] nums2) {

    }*/

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }

}
