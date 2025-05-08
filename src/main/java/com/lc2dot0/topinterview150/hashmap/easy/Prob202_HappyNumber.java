package com.lc2dot0.topinterview150.hashmap.easy;

import java.util.HashSet;
import java.util.Set;

public class Prob202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19) == true);
        System.out.println(isHappy(2) == false);
        System.out.println(isHappy(1) == true);
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int sum = digitSum(n);
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }

    private static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += ((n % 10) * (n % 10));
            n = n / 10;
        }
        return sum;
    }
}
