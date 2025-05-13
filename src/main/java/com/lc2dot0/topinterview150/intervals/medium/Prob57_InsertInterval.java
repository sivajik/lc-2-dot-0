package com.lc2dot0.topinterview150.intervals.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Prob57_InsertInterval {
    public static void main(String[] args) {
        for (var x : insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})) {
            System.out.println(Arrays.toString(x));
        }
        System.out.println();
        for (var x : insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        int[][] newIntervals = new int[intervals.length + 1][];
        for (int i = 0; i < intervals.length; i++) {
            newIntervals[i] = intervals[i];
        }
        newIntervals[intervals.length] = newInterval;

        Arrays.sort(newIntervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        //1,3 2,5 6,9
        List<int[]> op = new ArrayList<>();
        int[] currInterval = newIntervals[0];
        op.add(currInterval);

        for (var eachInterval : newIntervals) {
            int currStart = currInterval[0];
            int currEnd = currInterval[1];

            int eachStart = eachInterval[0];
            int eachEnd = eachInterval[1];

            if (currEnd >= eachStart) {
                currInterval[1] = Math.max(currEnd, eachEnd);
            } else {
                currInterval = eachInterval;
                op.add(currInterval);
            }
        }
        return op.toArray(new int[op.size()][]);
    }
}
