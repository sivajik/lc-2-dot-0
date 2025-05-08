package com.lc2dot0.topinterview150.arraystrings.medium;

import java.util.Arrays;

public class Prob238_ProdOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[] {-1, 1, 0, -3, 3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];

        prefixProd[0] = 1;
        suffixProd[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            prefixProd[i] = prefixProd[i-1] * nums[i-1];
        }

        for (int i = nums.length-2; i >= 0; i--) {
            suffixProd[i] = suffixProd[i+1] * nums[i+1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProd[i] * suffixProd[i];
        }
        return result;
    }
}

/*
a       b      c     d     e
1       a      ab    abc   abcd
bcde    cde    de    e     1
*/