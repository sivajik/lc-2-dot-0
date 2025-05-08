package com.lc2dot0.topinterview150.binarytreebfs.medium;

import com.lc2dot0.topinterview150.binarytreebfs.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.lc2dot0.topinterview150.binarytreebfs.TreeNodeUtils.prepareTree;

public class Prob103_BinTreeZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode n1 = prepareTree(new int[]{3, 9, 20, -999, -999, 15, 7});
        List<List<Integer>> l = zigzagLevelOrder(n1);
        System.out.println(l);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();

        if (root == null) {
            return l;
        }

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> eachList = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode t = q.poll();
                eachList.add(t.val);

                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            if (level % 2 != 0) {
                Collections.reverse(eachList);
            }
            l.add(eachList);
            level++;
        }

        return l;
    }
}
