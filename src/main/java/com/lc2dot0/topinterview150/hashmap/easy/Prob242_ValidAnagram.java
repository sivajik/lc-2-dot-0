package com.lc2dot0.topinterview150.hashmap.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob242_ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram") == true);
        System.out.println(isAnagram("rat", "car") == false);
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, 1 + map.get(c));
            } else {
                map.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                if (map.get(c) == 1) {
                    map.remove(c);
                } else if (map.get(c) > 1) {
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        return map.isEmpty();
    }
}
