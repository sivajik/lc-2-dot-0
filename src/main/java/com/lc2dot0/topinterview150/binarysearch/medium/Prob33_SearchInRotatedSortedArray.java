package com.lc2dot0.topinterview150.binarysearch.medium;

public class Prob33_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        //System.out.println(search(new int[]{2, 4, 6, 8, 10, 12, 14, 16}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3}, 2));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
