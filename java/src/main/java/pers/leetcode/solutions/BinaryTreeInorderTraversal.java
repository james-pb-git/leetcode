package pers.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;
import pers.leetcode.utils.*;
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
