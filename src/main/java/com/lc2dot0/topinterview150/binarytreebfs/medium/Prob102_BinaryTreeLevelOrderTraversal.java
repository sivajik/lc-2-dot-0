package com.lc2dot0.topinterview150.binarytreebfs.medium;

import com.lc2dot0.topinterview150.binarytreebfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.lc2dot0.topinterview150.binarytreebfs.TreeNodeUtils.prepareTree;

public class Prob102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode n1 = prepareTree(new int[]{3, 9, 20, -999, -999, 15, 7});
        List<List<Integer>> l = levelOrder(n1);
        System.out.println(l);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) {
            return l;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> eachLevelList = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode eachNode = q.poll();
                eachLevelList.add(eachNode.val);

                if (eachNode.left != null) {
                    q.offer(eachNode.left);
                }
                if (eachNode.right != null) {
                    q.offer(eachNode.right);
                }
            }
            l.add(eachLevelList);
        }

        return l;
    }
}
