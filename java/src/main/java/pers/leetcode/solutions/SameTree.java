package pers.leetcode.solutions;

/**
 * Created by bopang on 15/7/31.
 */
import pers.leetcode.utils.*;
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( null == p && null == q )
            return true;
        else if( null == p || null == q )
            return false;
        return ( p.val == q.val ) && isSameTree( p.left, q.left ) &&
                isSameTree( p.right, q.right );
    }
}
