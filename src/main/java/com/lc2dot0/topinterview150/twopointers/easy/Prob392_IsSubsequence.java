package com.lc2dot0.topinterview150.twopointers.easy;

public class Prob392_IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {
        int s1 = 0;
        int t1 = 0;

        while (s1 < s.length() && t1 < t.length()) {
            char s2 = s.charAt(s1);
            char t2 = t.charAt(t1);

            if (s2 == t2) {
                s1++;
                t1++;
            } else {
                t1++;
            }
        }
        return s1 == s.length() && t1 <= t.length();
    }
}
