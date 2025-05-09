package com.lc2dot0.topinterview150.binarytreegeneral.easy;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

public class Prob100_SameTree {
    public static void main(String[] args) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
