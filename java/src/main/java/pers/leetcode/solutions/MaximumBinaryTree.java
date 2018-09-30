package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 18/3/19.
 */
public class MaximumBinaryTree {
    private TreeNode constructMaximumBinaryTreeRecursive(int[] nums, int start, int end) {
        if (end < start)
            return null;
        if (start == end)
            return new TreeNode(nums[start]);
        int maxVal = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int idx = start; idx <= end; idx ++) {
            if (nums[idx] > maxVal) {
                maxVal = nums[idx];
                maxIdx = idx;
            }
        }
        TreeNode res = new TreeNode(maxVal);
        res.left = constructMaximumBinaryTreeRecursive(nums, start, maxIdx - 1);
        res.right = constructMaximumBinaryTreeRecursive(nums, maxIdx + 1, end);
        return res;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0)
            return null;
        return constructMaximumBinaryTreeRecursive(nums, 0, nums.length - 1);
    }
}
