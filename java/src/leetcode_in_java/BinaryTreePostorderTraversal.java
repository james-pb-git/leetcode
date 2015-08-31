package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

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
