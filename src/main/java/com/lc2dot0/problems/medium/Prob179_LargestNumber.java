package com.lc2dot0.problems.medium;

import java.util.Arrays;
import java.util.Comparator;

public class Prob179_LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10, 2}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }

    public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder sbr = new StringBuilder();
        for (String s : str) {
            sbr.append(s);
        }
        while (sbr.charAt(0) == '0' && sbr.length() > 1) {
            sbr.deleteCharAt(0);
        }
        return sbr.toString();
    }
}