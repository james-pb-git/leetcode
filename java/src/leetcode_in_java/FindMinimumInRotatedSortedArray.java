package leetcode_in_java;

/**
 * Created by bopang on 15/8/19.
 */
class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if( null == nums || nums.length == 0 )
            return 0;

        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        int midIdx = 0;

        int ans = 0;
        while( leftIdx <= rightIdx ) {
            midIdx = leftIdx + ( rightIdx - leftIdx ) / 2;

            // Attention: no duplicate exists in the array.
            if( nums[ leftIdx ] <= nums[ rightIdx ] ) {
                ans = nums[ leftIdx ];
                break;
            }
            else {
                if( nums[ midIdx ] >= nums[ leftIdx ] )
                    leftIdx = midIdx + 1;
                if( nums[ midIdx ] < nums[ rightIdx ] )
                    rightIdx = midIdx;
            }
        }
        return ans;
    }
}
