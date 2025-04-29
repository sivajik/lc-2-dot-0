package com.lc2dot0.easy;

public class Prob0125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("raccar"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome(".a."));
    }

    public static boolean isPalindrome(String s) {
        String str = s.trim().toLowerCase();

        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);
            while (!isAlphaNumeric(leftChar)) {
                left++;
                if (left < right) {
                    leftChar = str.charAt(left);
                } else {
                    return true;
                }
            }
            while (!isAlphaNumeric(rightChar)) {
                right--;
                if (right > 0) {
                    rightChar = str.charAt(right);
                } else {
                    return true;
                }
            }

            if (leftChar == rightChar) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
