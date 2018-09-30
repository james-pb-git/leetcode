package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/15.
 */
class ConvertSortedArrayToBinarySearchTree {
    private TreeNode recursiveSortedArrayToBST( int[] nums, int left, int right ) {
        TreeNode curHead = new TreeNode( 0 );
        if( left == right ) {
            curHead.val = nums[ left ];
            return curHead;
        }
        if( left > right ) {
            return null;
        }
        int mid = left + ( right - left ) / 2;
        curHead.val = nums[ mid ];
        curHead.left = recursiveSortedArrayToBST( nums, left, mid - 1);
        curHead.right = recursiveSortedArrayToBST( nums, mid + 1, right );
        return curHead;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if( null == nums || nums.length == 0 ) {
            return null;
        }
        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        return recursiveSortedArrayToBST(nums, leftIdx, rightIdx);

    }
}
