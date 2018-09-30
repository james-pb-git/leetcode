package pers.leetcode.solutions;
import pers.leetcode.utils.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 15/8/3.
 */
class LowestCommonAncestorOfABinaryTree {
    private boolean findPaths( TreeNode root, TreeNode p, TreeNode q,
                               List<TreeNode> pathP, List<TreeNode> pathQ, List<TreeNode> path) {

        if( pathP.size()>0 && pathQ.size()>0 )
            return true;

        if( null != root ) {
            path.add( root );
            if( root == p) {
                for( TreeNode node : path )
                    pathP.add( node );
            }
            if( root == q ) {
                for( TreeNode node : path )
                    pathQ.add( node );
            }
            findPaths( root.left, p, q, pathP, pathQ, path );
            findPaths( root.right, p, q, pathP, pathQ, path );
            path.remove( path.size() - 1 );
            if( pathP.size()==0 || pathQ.size()==0 )
                return false;
            return true;
        }
        return false;
    }
    private TreeNode findFirstCommonElement( List<TreeNode> pathP, List<TreeNode> pathQ ) {

        int lengthP = pathP.size();
        int lengthQ = pathQ.size();
        int minLength = lengthQ;
        if( lengthP < lengthQ )
            minLength = lengthP;

        int idx = 0;
        for( ; idx < minLength; idx ++ ) {
            if( pathP.get( idx ) != pathQ.get( idx ) )
                return pathP.get( idx - 1 );
        }
        return pathP.get( idx - 1 ); // In case the common element is the last element of one path.
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (null == root || null == p || null == q)
            return null;

        List<TreeNode> pathP = new ArrayList<TreeNode>();
        List<TreeNode> pathQ = new ArrayList<TreeNode>();
        List<TreeNode> path = new ArrayList<TreeNode>(); // Record the progress of traversal.
        boolean status = this.findPaths(root, p, q, pathP, pathQ, path);

        if (status)
            return this.findFirstCommonElement(pathP, pathQ);
        else
            return null;
    }
}
