package com.lc2dot0.easy;

public class Prob21_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode l3 = mergeTwoLists(l1, l2);
        print(l1);
        print(l2);
        print(l3);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode left = list1;
        ListNode right = list2;

        ListNode finalList = new ListNode(-999);
        ListNode result = finalList;
        while (left != null && right != null) {
            if (left.val < right.val) {
                finalList.next = new ListNode(left.val);
                finalList = finalList.next;
                left = left.next;
            } else if (left.val > right.val) {
                finalList.next = new ListNode(right.val);
                finalList = finalList.next;
                right = right.next;
            } else {
                finalList.next = new ListNode(left.val);
                finalList = finalList.next;
                finalList.next = new ListNode(right.val);
                finalList = finalList.next;
                left = left.next;
                right = right.next;
            }
        }

        if (left == null && right != null) {
            while (right != null) {
                finalList.next = new ListNode(right.val);
                finalList = finalList.next;
                right = right.next;
            }
        } else if (left != null && right == null) {
            while (left != null) {
                finalList.next = new ListNode(left.val);
                finalList = finalList.next;
                left = left.next;
            }
        }

        return result.next;
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
