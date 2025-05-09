package com.lc2dot0.topinterview150.binarytreegeneral.easy;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.preOrder;
import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.prepareTree;

public class Prob101_SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = prepareTree(new int[]{4, 2, 7, 1, 3, 6, 9});
        preOrder(root);
        System.out.println();
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSym(root.left, root.right);
    }

    private static boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}
