package com.lc2dot0.topinterview150.heap.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prob373_FindKPairsSmallestSums {
    public static void main(String[] args) {
        for (var x : kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3)) {
            System.out.println(x);
        }
        System.out.println();
        for (var x : kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2)) {
            System.out.println(x);
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return -o1.sum + o2.sum;
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(new Pair(nums1[i], nums2[j], nums1[i] + nums2[j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        while (k > 0) {
            List temp = new ArrayList();
            Pair p = pq.poll();
            temp.add(p.x);
            temp.add(p.y);
            //temp.add(p.sum);
            list.add(temp);
            k--;
        }
        return list;
    }

    static class Pair {
        int x;
        int y;
        int sum;

        Pair(int a, int b, int c) {
            this.x = a;
            this.y = b;
            this.sum = c;
        }
    }
}

