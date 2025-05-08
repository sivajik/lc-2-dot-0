package com.lc2dot0.topinterview150.arraystrings.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob58_LenghtOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World") == 5);
        System.out.println(lengthOfLastWord("H   fly me   to   the moon  ") == 4);
        System.out.println(lengthOfLastWord("luffy is still joyboy") == 6);
        System.out.println(lengthOfLastWord("Today is a nice day") == 3);
    }

    public static int lengthOfLastWord(String s) {
        /*String[] tokens = s.split(" ");
        return tokens[tokens.length - 1].length();*/

        /*String[] tokens = split(s);
        return tokens[tokens.length - 1].length();*/

        String str = s.trim();
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = chars.length-1; i >= 0; i--) {
            if (chars[i] != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private static String[] split(String str) {
        String s = str.trim();
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                sbr.append(chars[i]);

                if (i == chars.length - 1) {
                    if (!sbr.isEmpty()) {
                        list.add(sbr.toString());
                        break;
                    }
                }
            } else {
                if (!sbr.isEmpty()) {
                    list.add(sbr.toString());
                    sbr = new StringBuilder();
                }
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
