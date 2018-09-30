package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/4.
 */

import pers.leetcode.utils.*;

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if( null == root )
            return null;
        invertTree( root.left );
        invertTree( root.right );

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        return root;
    }
}
