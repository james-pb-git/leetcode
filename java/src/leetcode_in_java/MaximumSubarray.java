package leetcode_in_java;

/**
 * Created by bopang on 15/8/13.
 */
class MaximumSubarray {
    public int maxSubArray(int[] nums) {

        if( null == nums || nums.length == 0 )
            return 0;
        int maxSoFar = nums[0] - 1; // Make sure it's smaller than nums[0];
        int maxEndingHere = -1;
        for( int idx = 0; idx < nums.length; idx ++ ) {

            if( maxEndingHere < 0 )
                maxEndingHere = nums[ idx ];
            else
                maxEndingHere += nums[ idx ];

            if( maxEndingHere > maxSoFar )
                maxSoFar = maxEndingHere;
        }
        return maxSoFar;
    }
}
