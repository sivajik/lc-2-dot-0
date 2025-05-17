package com.lc2dot0.topinterview150.binarysearch.medium;

import java.util.Arrays;

public class Prob34_FindFirstandLastPosiSortedArr {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));

    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] arr = new int[]{-1, -1};
        _search(nums, 0, nums.length - 1, target, arr);
        return arr;
    }

    private static void _search(int[] nums, int l, int r, int target, int[] arr) {
        if (l > r) {
            return;
        }
        if (nums[l] == target && nums[r] == target) {
            arr[0] = l;
            arr[1] = r;
            return;
        }
        int m = l + (r - l) / 2;
        if (target > nums[m]) {
            _search(nums, m + 1, r, target, arr);
        } else if (target < nums[m]) {
            _search(nums, l, m - 1, target, arr);
        } else {
            arr[0] = m;
            arr[1] = m;
            int t = m;
            while (t > l && nums[t] == nums[t - 1]) {
                t = t - 1;
                arr[0] = t;
            }
            t = m;
            while (t < r && nums[t] == nums[t + 1]) {
                t = t + 1;
                arr[1] = t;
            }
            return;
            // a  b c d d d d  e f g
        }
        return;
    }
}
