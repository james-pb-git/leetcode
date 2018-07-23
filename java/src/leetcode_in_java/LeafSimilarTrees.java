package leetcode_in_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by bopang on 18/7/23.
 */
public class LeafSimilarTrees {

    // ------------- AC Sol1 --------------
    private void getLeafSequenceRecursive(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (root.left != null)
            getLeafSequenceRecursive(root.left, res);
        if (root.right != null)
            getLeafSequenceRecursive(root.right, res);
        if (root.left == null && root.right == null)
            res.add(root.val);
    }

    private List<Integer> getLeafSequence(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        getLeafSequenceRecursive(root, res);
        return res;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = getLeafSequence(root1);
        List<Integer> res2 = getLeafSequence(root2);

        return Arrays.equals(res1.toArray(), res2.toArray());
    }

    // -------------- AC Sol2 ----------------
    private Integer dfs(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (node.right == null && node.left == null)
                return node.val;
        }
        return null;
    }

    public boolean leafSimilarSol2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!dfs(stack1).equals(dfs(stack2)))
                return false;
        }
        if (!stack1.isEmpty() || !stack2.isEmpty())
            return false;
        return true;
    }

    // ------ Improved solution 2 --------
    private Integer dfsImproved(Stack<TreeNode> stack) {
        // When called, it's guaranteed the satck is not empty.
        while (true) {
            TreeNode node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (node.right == null && node.left == null)
                return node.val;
        }
    }

    public boolean leafSimilarSol2Improved(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!dfsImproved(stack1).equals(dfsImproved(stack2)))
                return false;
        }
        /*if (!stack1.isEmpty() || !stack2.isEmpty())
            return false;
        return true;*/
        // Logic simplified.
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
