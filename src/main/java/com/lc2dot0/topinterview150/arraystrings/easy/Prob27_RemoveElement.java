package com.lc2dot0.topinterview150.arraystrings.easy;

public class Prob27_RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[] {0,1,2,2,3,0,4,2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}


// 0 1 X 4 3 0 4 X 8