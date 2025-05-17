package com.lc2dot0.topinterview150.binarysearch.medium;

public class Prob162_FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public static int findPeakElement(int[] nums) {
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];
            int next = nums[i + 1];
            if (curr > prev && curr > next && curr > max) {
                max = curr;
                index = i;
            }
        }
        if (nums[nums.length - 1] > max) {
            index = nums.length - 1;
        }
        return index;
    }
}

// a b c d e
