package leetcode_in_java;

/**
 * Created by bopang on 15/8/30.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if( null == nums || nums.length == 0 )
            return 0;

        int leftIdx = 0;
        int rightIdx = nums.length - 1;
        int midIdx = 0;

        int ans = 0;
        while( leftIdx <= rightIdx ) {
            midIdx = leftIdx + ( rightIdx - leftIdx ) / 2;

            if( nums[ leftIdx ] < nums[ rightIdx ] ) {
                ans = nums[ leftIdx ];
                break;
            }
            else if( nums[ leftIdx ] > nums[ rightIdx ]) {
                if( nums[ midIdx ] >= nums[ leftIdx ] )
                    leftIdx = midIdx + 1;
                if( nums[ midIdx ] <= nums[ rightIdx ] )
                    rightIdx = midIdx;
            }
            else {
                ans = nums[ leftIdx ];
                for( int idx = leftIdx+1; idx <= rightIdx; idx ++ ) {
                    if( nums[ idx ] < ans )
                        ans = nums[ idx ];
                }
                return ans;
            }
        }
        return ans;
    }
}
