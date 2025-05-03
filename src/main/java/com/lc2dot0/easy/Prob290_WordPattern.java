package com.lc2dot0.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob290_WordPattern {
    public static void main(String[] args) {
        /*System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(!wordPattern("abba", "dog cat cat fish"));
        System.out.println(!wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(!wordPattern("abba", "dog dog dog dog"));
*/
        System.out.println(!wordPattern("abba", "dog dog dog dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> char2StrMap = new HashMap<>();
        Map<String, Character> str2CharMap = new HashMap<>();

        char[] chars = pattern.toCharArray();
        String[] tokens = s.split("\\s+");

        if (chars.length != tokens.length) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (!char2StrMap.containsKey(chars[i]) && !str2CharMap.containsKey(tokens[i])) {
                char2StrMap.put(chars[i], tokens[i]);
                str2CharMap.put(tokens[i], chars[i]);
            } else {
                if (char2StrMap.containsKey(chars[i]) && !char2StrMap.get(chars[i]).equals(tokens[i])) {
                    return false;
                }

                if (str2CharMap.containsKey(tokens[i]) && str2CharMap.get(tokens[i]) != chars[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
