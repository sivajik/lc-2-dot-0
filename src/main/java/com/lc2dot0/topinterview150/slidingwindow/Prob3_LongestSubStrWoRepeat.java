package com.lc2dot0.topinterview150.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Prob3_LongestSubStrWoRepeat {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        while (i < chars.length && j < chars.length) {
            char c = chars[j];
            if (seen.contains(c)) {
                seen.remove(chars[i]);
                i++;
            } else {
                seen.add(c);
                maxLen = Math.max(maxLen, seen.size());
                j++;
            }
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
