package com.lc2dot0.topinterview150.slidingwindow;

public class Prob209_MinSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int left = 0;
        int seqLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                seqLen = Math.min(seqLen, i + 1 - left);
                sum = sum - nums[left];
                left++;
            }
        }
        return seqLen == Integer.MAX_VALUE ? 0 : seqLen;
    }
}
