package com.lc2dot0.topinterview150.arraystrings.easy;

public class Prob14_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }

        for (int j = 0; j < minLen; j++) {
            char prev = '0';
            for (int i = 0; i < strs.length; i++) {
                if (i == 0) {
                    prev = strs[i].charAt(j);
                    continue;
                }
                if (strs[i].charAt(j) != prev) {
                    return strs[i].substring(0, j);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
