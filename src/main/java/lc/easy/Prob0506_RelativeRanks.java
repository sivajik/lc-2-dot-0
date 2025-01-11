package lc.easy;

import java.util.*;

public class Prob0506_RelativeRanks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
    }

    static public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int j : score) {
            pq.add(j);
        }
        for (int i = 0; i < score.length; i++) {
            map.put(pq.poll(), i);
        }

        String[] op = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = map.get(score[i]);
            if (rank == 0) {
                op[i] = "Gold Medal";
            } else if (rank == 1) {
                op[i] = "Silver Medal";
            } else if (rank == 2) {
                op[i] = "Bronze Medal";
            } else {
                op[i] = String.valueOf(rank + 1);
            }
        }
        return op;
    }
}
