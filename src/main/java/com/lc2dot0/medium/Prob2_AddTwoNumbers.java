package com.lc2dot0.medium;

import java.util.List;
import java.util.Stack;

public class Prob2_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode l3 = addTwoNumbers(l1, l2);
        print(l3);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode l3 = null;
        int carryOn = 0;
        while (t1 != null && t2 != null) {
            int sum = t1.val + t2.val + carryOn;
            l3 = new ListNode(sum % 10, l3);
            carryOn = sum / 10;
            t1 = t1.next;
            t2 = t2.next;
        }

        if (t1 == null && t2 != null) {
            while (t2 != null) {
                int sum = t2.val + carryOn;
                l3 = new ListNode(sum % 10, l3);
                carryOn = sum / 10;
                t2 = t2.next;
            }
        } else if (t1 != null) {
            while (t1 != null) {
                int sum = t1.val + carryOn;
                l3 = new ListNode(sum % 10, l3);
                carryOn = sum / 10;
                t1 = t1.next;
            }
        }

        if (carryOn > 0) {
            l3 = new ListNode(carryOn, l3);
        }
        return reverse(l3);
    }

    static ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
