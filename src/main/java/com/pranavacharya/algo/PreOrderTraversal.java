package com.pranavacharya.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current == null) {
                list.add(null);
            } else {
                list.add(current.val);
                if (!(current.left == null && current.right == null)) {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
        }
        return list;
    }

    public void insertNode(TreeNode root, int node) {
        TreeNode head = root;
        while (head != null) {
            if (head.val == node) {
                return;
            }
            if (head.val > node) {
                if (head.left == null) {
                    head.left = new TreeNode(node);
                    break;
                }
                head = head.left;
            }
            if (head.val < node) {
                if (head.right == null) {
                    head.right = new TreeNode(node);
                    break;
                }
                head = head.right;
            }
        }
    }

    public TreeNode createBST(int[] nodes) {
        if (nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        for (int node : nodes) {
            insertNode(root, node);
        }
        return root;
    }

    public static void main(String args[]) {
        PreOrderTraversal pot = new PreOrderTraversal();
        int[] nodes = new int[]{8, 5, 1, 7, 10, 12};
        TreeNode root = pot.createBST(nodes);
        ArrayList<Integer> list = pot.preorderTraversal(root);
        System.out.println(list.toString());
    }
}
