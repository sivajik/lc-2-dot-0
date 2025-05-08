package com.lc2dot0.topinterview150.linkedlist.easy;

public class Prob141_LinkedListCycle {
    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode thr = new ListNode(0);
        ListNode fou = new ListNode(4);

        one.next = two;
        two.next = thr;
        thr.next = fou;
        //fou.next = two;

        System.out.println(hasCycle(one));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
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

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
