package leetcode_in_java;

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
}
