package com.lc2dot0.topinterview150.binarytreegeneral.easy;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.prepareTree;

public class Prob104_MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = prepareTree(new int[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
