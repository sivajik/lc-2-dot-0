package com.lc2dot0.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob383_RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b") == false);
        System.out.println(canConstruct("aa", "ab") == false);
        System.out.println(canConstruct("aa", "aab") == true);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> set = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (set.containsKey(c)) {
                set.put(c, 1 + set.get(c));
            } else {
                set.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!set.containsKey(c)) {
                return false;
            } else {
                if (set.get(c) <= 0) {
                    return false;
                }
                set.put(c, set.get(c) - 1);
            }
        }
        return true;
    }
}
