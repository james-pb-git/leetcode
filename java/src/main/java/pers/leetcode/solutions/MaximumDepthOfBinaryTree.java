package pers.leetcode.solutions;

/**
 * Created by bopang on 15/7/29.
 */
import pers.leetcode.utils.*;
class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if( null == root )
            return 0;
        int leftRes = maxDepth( root.left );
        int rightRes = maxDepth( root.right );
        if( leftRes > rightRes )
            return leftRes + 1;
        return rightRes + 1 ;
    }
}
