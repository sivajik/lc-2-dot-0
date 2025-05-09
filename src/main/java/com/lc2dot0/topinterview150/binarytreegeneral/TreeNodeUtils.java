package com.lc2dot0.topinterview150.binarytreegeneral;


public class TreeNodeUtils {
    public static TreeNode prepareTree(int[] values) {
        TreeNode[] treeArray = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] == -999) {
                treeArray[i] = null;
            } else {
                treeArray[i] = new TreeNode(values[i]);
            }
        }

        for (int i = 0; i < values.length; i++) {
            TreeNode node = treeArray[i];
            if (((2 * i) + 1 < values.length) && ((2 * i) + 2 < values.length)) {
                node.left = treeArray[(2 * i) + 1];
                node.right = treeArray[(2 * i) + 2];
            }
        }
        return treeArray[0];
    }

    public static void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.print(tree.val + " ");
            inOrder(tree.right);
        }
    }

    public static void preOrder(TreeNode tree) {
        if (tree != null) {
            System.out.print(tree.val + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public static void postOrder(TreeNode tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.val + " ");
        }
    }
}
