package com.lc2dot0.topinterview150.arraystrings.easy;

import java.util.Arrays;

public class Prob88_MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int z = m + n - 1;
        while (y >= 0) {
            if (x >=0 && nums1[x] > nums2[y] ) {
                nums1[z--] = nums1[x--];
            } else {
                nums1[z--] = nums2[y--];
            }
        }
    }
}
