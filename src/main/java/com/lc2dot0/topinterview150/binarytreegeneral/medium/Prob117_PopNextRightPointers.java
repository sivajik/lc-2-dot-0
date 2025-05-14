package com.lc2dot0.topinterview150.binarytreegeneral.medium;

import com.lc2dot0.topinterview150.binarytreegeneral.Node;
import com.lc2dot0.topinterview150.binarytreegeneral.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.inOrder;
import static com.lc2dot0.topinterview150.binarytreegeneral.TreeNodeUtils.postOrder;

public class Prob117_PopNextRightPointers {
    public static void main(String[] args) {
        /*TreeNode t = connect(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        inOrder(t);
        System.out.println();
        postOrder(t);*/
    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node t = q.poll();
                list.add(t);
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
            }
            if (list.size() > 1) {
                for (int i = 0; i < list.size() - 1; i++) {
                    list.get(i).next = list.get(i + 1);
                }
            }
        }
        return root;
    }
}
