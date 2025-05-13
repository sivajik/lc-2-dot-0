package com.lc2dot0.topinterview150.binarysearch.medium;

public class Prob153_FindMinInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}) == 1);
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}) == 0);
        System.out.println(findMin(new int[]{11, 3, 15, 17}) == 3);
        System.out.println(findMin(new int[]{3, 1}) == 1);
        System.out.println(findMin(new int[]{3, 1, 2}) == 1);
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
