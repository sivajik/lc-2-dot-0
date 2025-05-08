package com.lc2dot0.topinterview150.arraystrings.easy;

import java.util.Arrays;

public class Prob169_MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }

            if (n == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static int majorityElementBoring(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
