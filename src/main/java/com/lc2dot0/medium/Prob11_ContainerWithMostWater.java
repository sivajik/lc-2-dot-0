package com.lc2dot0.medium;

public class Prob11_ContainerWithMostWater {
    public static void main(String[] args) {
        //System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
