package com.lc2dot0.medium;

public class Prob61_RotateList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, null)))));
        print(l1);
        ListNode res = rotateRight(l1, 2);
        print(res);

        ListNode l2 = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        print(l2);
        ListNode res2 = rotateRight(l2, 4);
        print(res2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode d = head;
        int len = 0;
        while (d != null) {
            d = d.next;
            len++;
        }
        k = k % len;

        if (k == 0) {
            return head;
        }

        ListNode left = head;

        for (int i = 0; i < len - k - 1; i++) {
            left = left.next;
        }
        ListNode right = left.next;
        left.next = null;
        ListNode newHead = right;
        while (right.next != null) {
            right = right.next;
        }
        right.next = head;
        return newHead;

        /*

        ListNode lastNode = null;
        for (int i = 0; i < k; i++) {
            ListNode newHead = head;
            // get the value of last node & remove the last node
            while (head.next != null && head.next.next != null) {
                head = head.next;
            }
            int lastNodeVal = head.next.val;
            head.next = null;
            lastNode = new ListNode(lastNodeVal, newHead);
            head = lastNode;
        }
        return lastNode;*/
    }

    public static void print(ListNode l) {
        ListNode temp = l;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
