package lc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob00001_PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 3}, 6)));
    }

    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            int right = target - left;
            if (map.containsKey(right)) {
                List<Integer> indices = map.get(right);
                if (indices.size() == 1 && indices.getFirst() != i) {
                    return new int[]{i, indices.getFirst()};
                } else {
                    for (Integer index : indices) {
                        if (index > i) {
                            return new int[]{i, index};
                        }
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }
}
