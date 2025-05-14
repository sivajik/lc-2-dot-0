package com.lc2dot0.topinterview150.hashmap.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob128_LongestConsecutiveSeq {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) == 4);
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) == 9);
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}) == 3);
        System.out.println(longestConsecutive(new int[]{-6, -1, -1, 9, -8, -6, -6, 4, 4, -3, -8, -1}) == 1);

    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }

        if (set.size() == 1) {
            return 1;
        }

        int res = 0;
        for (var x : set) {
            int num = x - 1;

            if (!set.contains(num)) {
                // check next set
                int currNum = x;
                int len = 1;
                while (set.contains(currNum + 1)) {
                    len++;
                    currNum = currNum + 1;
                }
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
