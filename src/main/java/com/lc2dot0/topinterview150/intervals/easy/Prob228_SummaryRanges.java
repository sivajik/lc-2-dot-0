package com.lc2dot0.topinterview150.intervals.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob228_SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int end = nums[i];
            boolean found = false;
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                end = nums[i + 1];
                i++;
                found = true;
            }

            if (found) {
                res.add(start + "->" + end);
            } else {
                res.add("" + start);
            }
        }

        return res;
    }
}
