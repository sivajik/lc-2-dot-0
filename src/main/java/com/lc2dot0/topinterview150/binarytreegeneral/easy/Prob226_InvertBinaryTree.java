package com.lc2dot0.topinterview150.binarytreegeneral.easy;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.preOrder;
import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.prepareTree;

public class Prob226_InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = prepareTree(new int[]{4, 2, 7, 1, 3, 6, 9});
        preOrder(root);
        System.out.println();
        root = invertTree(root);
        preOrder(root);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode tempL = root.left;
            TreeNode tempR = root.right;
            root.right = tempL;
            root.left = tempR;

            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
