package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 15/8/3.
 */
class LowestCommonAncestorOfABinarySearchTree {

    private TreeNode lcaOfBST( TreeNode root, TreeNode p, TreeNode q ) {
        if( null != root ) {
            if( ( p.val <= root.val && root.val <= q.val ) ||
                    ( q.val <= root.val && root.val <= p.val ) )
                return root;
            
            TreeNode ans = lcaOfBST( root.left, p, q );
            if( null == ans )
                ans = lcaOfBST( root.right, p, q );
            return ans;
        }
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (null == root || null == p || null == q)
            return null;

        return this.lcaOfBST( root, p, q );
    }
}
