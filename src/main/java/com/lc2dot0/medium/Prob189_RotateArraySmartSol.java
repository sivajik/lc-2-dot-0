package com.lc2dot0.medium;

import java.util.Arrays;

public class Prob189_RotateArraySmartSol {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }

    public static void rotate(int[] nums, int k) {
        /*1 2 3 4 5 6 7
        7 6 5 4 3 2 1
        5 6 7 1 2 3 4*/
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
