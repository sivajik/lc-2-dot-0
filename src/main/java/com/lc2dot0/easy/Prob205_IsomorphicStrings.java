package com.lc2dot0.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob205_IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add") == true);
        System.out.println(isIsomorphic("foo", "bar") == false);
        System.out.println(isIsomorphic("paper", "title") == true);
        System.out.println(isIsomorphic("badc", "baba") == false);
    }

    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s, t) && isIsomorphic1(t, s);
    }

    public static boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (int i = 0; i < s1.length; i++) {
            if (!map.containsKey(s1[i])) {
                map.put(s1[i], t1[i]);
            } else {
                if (map.get(s1[i]) != t1[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
