package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    private Integer dfs(Stack<TreeNode> stack) {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!dfs(stack1).equals(dfs(stack2)))
                return false;
        }
        /*if (!stack1.isEmpty() || !stack2.isEmpty())
            return false;
        return true;*/
        // Logic simplified.
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();
        Integer a = 2;
        Integer b = new Integer(2);
        System.out.println(a);
        System.out.println(b.equals(a));
    }
}