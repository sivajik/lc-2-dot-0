package com.lc2dot0.topinterview150.linkedlist.medium;

public class Prob19_RemoveNthNodeFromLast {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
                new ListNode(5, null)))));
        print(l1);
        ListNode res = removeNthFromEnd(l1, 2);
        print(res);
    }

    /*
    reverse from end is nothing from keeping 2 pointers away of 'n' distance
    and moving them so that fast pointer terminates - which leaves us n-1 position.
    any operation where head also goes off - keep a dummy head so that it makes easy
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(-999);
        newHead.next = head;

        ListNode slow = newHead;
        ListNode fast = newHead;

        /**
         * [-999] p o n m l .k. a b c d e 'F' g h i j
         */
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return newHead.next;
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
