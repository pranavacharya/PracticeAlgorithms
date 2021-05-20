package com.pranavacharya.interviewbit;

import com.pranavacharya.hackerrank.TreeNode;

public class ValidBinarySearchTree {

    public int isValidBST(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return helper(A, null, null) ? 1 : 0;
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);

    }

}
