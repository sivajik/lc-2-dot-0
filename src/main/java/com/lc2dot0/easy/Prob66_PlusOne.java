package com.lc2dot0.easy;

import java.util.Arrays;

public class Prob66_PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        int carryOn = 0;
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carryOn;
            }
            digits[i] = sum % 10;
            carryOn = sum / 10;
        }

        if (carryOn > 0) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = carryOn;
            System.arraycopy(digits, 0, newArr, 1, digits.length);
            return newArr;
        } else {
            return digits;
        }
    }
}
