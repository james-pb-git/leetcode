package leetcode_in_java;

/**
 * Created by bopang on 15/7/30.
 */
class SingleNumber {
    public int singleNumber(int[] nums) {
        if( (nums == null) || nums.length == 0 )
            return 0;
        int ans = nums[0];
        for( int idx = 1; idx < nums.length; idx++ ) {
            ans ^= nums[idx];
        }
        return ans;
    }
}
