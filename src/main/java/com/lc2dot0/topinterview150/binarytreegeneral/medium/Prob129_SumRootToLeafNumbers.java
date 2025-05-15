package com.lc2dot0.topinterview150.binarytreegeneral.medium;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;
import com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.inOrder;

public class Prob129_SumRootToLeafNumbers {
    public static void main(String[] args) {
        TreeNode t = TreeNodeUtils.prepareTree(new int[]{4, 9, 0, 5, 1, -999, -999});
        inOrder(t);
        System.out.println();
        System.out.println(sumNumbers(t));
    }

    public static int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private static int sum(TreeNode root, int multipler) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val + (10 * multipler);
        }

        int l = sum(root.left, root.val + (10 * multipler));
        int r = sum(root.right, root.val + (10 * multipler));
        return l + r;
    }
}
