package com.lc2dot0.topinterview150.arraystrings.medium;

public class Rob151_ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue").equals("blue is sky the"));
    }
    public static String reverseWords(String s) {
        String[] tokens = s.trim().split(" ");
        StringBuilder sbr = new StringBuilder();
        for (int i = tokens.length-1; i >= 0; i--) {
            if (!tokens[i].trim().isEmpty()) {
                sbr.append(tokens[i]);
                sbr.append(" ");
            }
        }
        return sbr.toString().trim();
    }
}
