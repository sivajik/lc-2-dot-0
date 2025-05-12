package com.lc2dot0.topinterview150.binarytreegeneral.medium;

import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.inOrder;

public class Prob106_TreeFromPreOrderInOrder {
    public static void main(String[] args) {
        TreeNode t = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        inOrder(t);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return _buildTree(map, inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
    }

    private static TreeNode _buildTree(Map<Integer, Integer> map, int[] inorder, int inLeft, int inRight,
                                int[] preorder, int prLeft, int prRight) {

        if (inLeft > inRight || prLeft > prRight) {
            return null;
        }

        int rootNodeVal = preorder[prLeft];
        int rootIndex = map.get(rootNodeVal);

        int inLeftStart = inLeft;
        int inLeftEnd = rootIndex - 1;
        int preLeftStart = prLeft + 1;
        // start from where left starts and add X elements (all left of 3 i.e. inLeftEnd-inLeftSTart
        int preLeftend = preLeftStart + inLeftEnd - inLeftStart;

        int inrightStart = rootIndex + 1;
        int inRightEnd = inRight;
        int preRihtStart = preLeftend + 1;
        int preRightEnd = prRight;

        TreeNode root = new TreeNode(preorder[prLeft]);
        root.left = _buildTree(map, inorder, inLeftStart, inLeftEnd,
                preorder, preLeftStart, preLeftend);

        root.right = _buildTree(map, inorder, inrightStart, inRightEnd, preorder,
                preRihtStart, preRightEnd);
        return root;
    }
}
