package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/10.
 */
class SearchInsertPosition {
    private int binarySearchInsert( int[] nums, int target, int left, int right ) {
        while( left <= right ) {
            int midIdx = left + ( right - left )/2;
            int midVal = nums[ midIdx ];
            if( target < midVal )
                right = midIdx - 1;
            else if( target > midVal )
                left = midIdx + 1;
            else
                return midIdx;
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        if( null == nums || nums.length == 0 )
            return 0;
        return binarySearchInsert( nums, target, 0, nums.length - 1 );
    }

    /* Below is another solution. The while loop ends when left == right,
    and it never returns inside the while loop.
    Whenever it ends, we must have left == right.
    So briefly speaking it's a clearer and cleaner solution, in my opinion,
    although the return statement is a little more nuanced.
     */

    public int searchInsertSol2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (target <= nums[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return (target > nums[left]) ? left + 1 : left;
    }
}
