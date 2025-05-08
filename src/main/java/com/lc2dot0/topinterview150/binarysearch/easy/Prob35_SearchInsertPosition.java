package com.lc2dot0.topinterview150.binarysearch.easy;

public class Prob35_SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                h = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}


