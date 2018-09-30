package pers.leetcode.solutions;

import java.util.Arrays;

/**
 * Created by bopang on 18/3/20.
 */
public class ArrayPartitionI {
    /* important note: the efficiency can be improved by using linear time sorting algorithm.
 */
    public int arrayPairSum(int[] nums) {
        if( null == nums)
            return 0;
        Arrays.sort(nums);
        int res = 0;
        for(int idx = 0; idx < nums.length; idx += 2)
            res += nums[idx];
        return res;
    }
}
