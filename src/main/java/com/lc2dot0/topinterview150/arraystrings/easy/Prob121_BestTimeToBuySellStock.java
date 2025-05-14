package com.lc2dot0.topinterview150.arraystrings.easy;

public class Prob121_BestTimeToBuySellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5);
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int elem : prices) {
            min = Math.min(min, elem);
            max = Math.max(max, elem - min);
        }
        return max;
    }
}
