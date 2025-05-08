package com.lc2dot0.topinterview150.binarytreebfs.easy;

import com.lc2dot0.topinterview150.binarytreebfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.lc2dot0.topinterview150.binarytreebfs.TreeNodeUtils.prepareTree;

public class Prob637_AverageLevelsInBinTree {
    public static void main(String[] args) {
        TreeNode n1 = prepareTree(new int[]{3, 9, 20, -999, -999, 15, 7});
        List<Double> l = averageOfLevels(n1);
        System.out.println(l);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }

            }
            result.add(sum / len);
        }
        return result;
    }
}
