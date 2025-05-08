package com.lc2dot0.topinterview150.hashmap.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob1_TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            if (map.containsKey(nums[i]) && map.containsKey(required) && i != map.get(required)) {
                return new int[]{i, map.get(required)};
            }
        }
        return null;
    }
}
