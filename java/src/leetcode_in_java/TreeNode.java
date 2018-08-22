package leetcode_in_java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bopang on 15/7/29.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        // TreeNode root = new TreeNode(Integer.parseInt(item));
        val = Integer.parseInt(item);
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        //nodeQueue.add(root);
        nodeQueue.add(this);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return;
    }
}