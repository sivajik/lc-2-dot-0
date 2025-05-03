package com.lc2dot0.medium;

import java.util.Arrays;

public class Prob189_RotateArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        rotate(a, 3);
        System.out.println(Arrays.toString(a));
    }

    public static void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        if (nums.length < k) {
            k = k % nums.length;
        }

        int[] rotated = new int[nums.length];

        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            rotated[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            rotated[j++] = nums[i];
        }
        System.arraycopy(rotated, 0, nums, 0, rotated.length);
    }
}
