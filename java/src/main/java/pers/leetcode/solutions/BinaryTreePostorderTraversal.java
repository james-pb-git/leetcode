package pers.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/23.
 */
class BinaryTreePostorderTraversal {
    private void postorderTraversalWithList( TreeNode root, List<Integer> list ) {
        if( null == root )
            return;
        postorderTraversalWithList( root.left, list );
        postorderTraversalWithList( root.right, list );
        list.add( root.val );
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        postorderTraversalWithList( root, ans );
        return ans;
    }
}
