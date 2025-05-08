package com.lc2dot0.topinterview150.heap.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prob215_KthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int n : nums) {
            q.add(n);
        }
        int count = 0;
        int result = -1;
        while (count++ < k) {
            result = q.poll();
        }
        return result;
    }
}
