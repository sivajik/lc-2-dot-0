package com.lc2dot0.topinterview150.arraystrings.easy;

public class Prob28_IndexOfFirstOccurence {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad") == 0);
        System.out.println(strStr("sadbutsad", "but") == 3);
        System.out.println(strStr("sadbutsad", "butty") == -1);
        System.out.println(strStr("a", "a") == 0);
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() <= haystack.length()) {
                String sub = subOf(haystack, i, i + needle.length());//haystack.substring(i, i+needle.length());
                if (sub.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static String subOf(String str, int start, int end) {
        char[] c = new char[end-start];
        char[] chars = str.toCharArray();
        int window = end - start;
        for (int i = 0; i < window; i++) {
            c[i] = chars[start++];
        }
        return new String(c);
    }
}
