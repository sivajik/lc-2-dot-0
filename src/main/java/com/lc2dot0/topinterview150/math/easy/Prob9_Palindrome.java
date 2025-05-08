package com.lc2dot0.topinterview150.math.easy;

public class Prob9_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(!isPalindrome(-121));
        System.out.println(!isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int rev = 0;
        int orig = x;
        while (x > 0) {
            int lDigit = x % 10;
            rev = rev * 10 + lDigit;
            x = x / 10;
        }
        return rev == orig;
    }
}