package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/20.
 */

import pers.leetcode.utils.*;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        /* This is useless!
        if (null == t1 && null == t2)
            return null;
        */
        if (null == t1) return t2;
        if (null == t2) return t1;
        TreeNode res = new TreeNode(t1.val + t2.val);
        res.left = mergeTrees(t1.left, t2.left);
        res.right = mergeTrees(t1.right, t2.right);
        return res;
    }
}
