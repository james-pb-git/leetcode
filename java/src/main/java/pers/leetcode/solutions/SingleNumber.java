package pers.leetcode.solutions;

/**
 * Created by bopang on 15/7/30.
 */
public class SingleNumber {
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
