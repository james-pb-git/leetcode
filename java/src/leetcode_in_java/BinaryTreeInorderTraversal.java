package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 15/8/7.
 */
class BinaryTreeInorderTraversal {
    private void iterativeInorderTraversal( TreeNode root, List<Integer> ans ) {
        if( null == root )
            return;
        iterativeInorderTraversal(root.left, ans);
        ans.add(root.val);
        iterativeInorderTraversal( root.right, ans );
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        iterativeInorderTraversal( root, ans );
        return ans;
    }
}
