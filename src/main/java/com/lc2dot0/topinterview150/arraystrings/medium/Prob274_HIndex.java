package com.lc2dot0.topinterview150.arraystrings.medium;

import java.util.Arrays;

public class Prob274_HIndex {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int c = citations.length - i;
            if (citations[i] >= c) {
                return c;
            }
        }
        return 0;
    }
}
