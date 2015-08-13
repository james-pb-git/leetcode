package leetcode_in_java;

/**
 * Created by bopang on 15/8/4.
 */
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
