package com.lc2dot0.topinterview150.binarytreegeneral.medium;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.inOrder;
import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.postOrder;

public class Prob106_TreeFromPostOrderInOrder {
    public static void main(String[] args) {
        TreeNode t = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        inOrder(t);
        System.out.println();
        postOrder(t);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return _buildTree(map, inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode _buildTree(Map<Integer, Integer> map, int[] inOrder, int inStart, int inEnd,
                                       int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootNodeVal = postOrder[postEnd];
        int rootIndex = map.get(rootNodeVal);

        int inLeftStart = inStart;
        int inLeftEnd = rootIndex - 1;
        int postLeftStart = postStart;
        int postLeftend = postLeftStart + inLeftEnd - inLeftStart;

        int inrightStart = rootIndex + 1;
        int inRightEnd = inEnd;
        int postRightStart = postLeftend + 1;
        int postRightEnd = postEnd - 1;

        TreeNode root = new TreeNode(rootNodeVal);
        root.left = _buildTree(map, inOrder, inLeftStart, inLeftEnd,
                postOrder, postLeftStart, postLeftend);

        root.right = _buildTree(map, inOrder, inrightStart, inRightEnd, postOrder,
                postRightStart, postRightEnd);
        return root;
    }
}