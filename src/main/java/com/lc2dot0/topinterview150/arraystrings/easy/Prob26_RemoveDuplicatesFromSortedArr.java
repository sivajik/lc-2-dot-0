package com.lc2dot0.topinterview150.arraystrings.easy;

import java.util.Arrays;

public class Prob26_RemoveDuplicatesFromSortedArr {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                r++;
            } else {
                l++;
                nums[l] = nums[r];
            }
        }
        System.out.print(Arrays.toString(nums));
        return l + 1;
    }
}
