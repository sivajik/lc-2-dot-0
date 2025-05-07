package com.lc2dot0.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob219_ContainsDuplicate2 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(!containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                if (Math.abs(list.getLast() - i) <= k) {
                    return true;
                } else {
                    list.add(i);
                    map.put(nums[i], list);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return false;
    }
}

