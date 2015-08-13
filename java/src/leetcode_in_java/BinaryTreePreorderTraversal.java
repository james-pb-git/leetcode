package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 15/8/7.
 */
class BinaryTreePreorderTraversal {
    private void iterativePreorderTraversal( TreeNode root, List<Integer> ans ) {
        if( null == root )
            return;
        ans.add(root.val);
        iterativePreorderTraversal(root.left, ans);
        iterativePreorderTraversal( root.right, ans );
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        iterativePreorderTraversal( root, ans );
        return ans;
    }
}
