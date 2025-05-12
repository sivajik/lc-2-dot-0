package com.lc2dot0.topinterview150.intervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Prob56_MergeIntervals {
    public static void main(String[] args) {
        var op = merge(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        });
        for (var x : op) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] intervalOne, int[] intervalTwo) {
                return intervalOne[0] - intervalTwo[0];
            }
        });

        List<int[]> op = new ArrayList<>();
        int[] currInterval = intervals[0];
        op.add(currInterval);

        for (var eachInterval : intervals) {
            int currStart = currInterval[0];
            int currEnd = currInterval[1];

            int nextStart = eachInterval[0];
            int nextEnd = eachInterval[1];


            if (currEnd >= nextStart) {
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else {
                currInterval = eachInterval;
                op.add(currInterval);
            }

        }
        return op.toArray(new int[op.size()][]);
    }


    // 1 6 8 10
}
