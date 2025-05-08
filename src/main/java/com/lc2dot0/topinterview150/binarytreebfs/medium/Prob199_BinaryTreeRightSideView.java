package com.lc2dot0.topinterview150.binarytreebfs.medium;

import com.lc2dot0.topinterview150.binarytreebfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.lc2dot0.topinterview150.binarytreebfs.TreeNodeUtils.prepareTree;

public class Prob199_BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode n1 = prepareTree(new int[]{1, 2, 3, -999, 5, -999, 4});
        List<Integer> l = rightSideView(n1);
        System.out.println(l);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();

        if (root == null) {
            return l;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode x = q.poll();

                if (x.left != null) {
                    q.add(x.left);
                }
                if (x.right != null) {
                    q.add(x.right);
                }
                if (i == len - 1) {
                    l.add(x.val);
                }
            }
        }

        return l;
    }
}
