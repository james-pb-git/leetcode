package pers.leetcode.solutions;

import java.util.Arrays;

/**
 * Created by bopang on 15/8/10.
 */
class MajorityElement {
    public int majorityElement(int[] nums) {
        if( null == nums || nums.length == 0 )
            return 0;

        Arrays.sort(nums);
        return nums[ nums.length/2 ];

    }
}
