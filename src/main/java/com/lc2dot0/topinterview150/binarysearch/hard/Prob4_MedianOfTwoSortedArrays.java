package com.lc2dot0.topinterview150.binarysearch.hard;

public class Prob4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                res[k++] = nums2[j++];
            } else {
                res[k++] = nums1[i++];
                res[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            res[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            res[k++] = nums2[j++];
        }
        if (res.length % 2 == 1) {
            return res[res.length / 2];
        } else {
            int mid1 = res[res.length / 2];
            int mid2 = res[(res.length / 2) - 1];
            return (mid1 + mid2) / 2.0;
        }
    }
}
