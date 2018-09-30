package pers.leetcode.solutions;

/**
 * Created by bopang on 18/8/13.
 */
public class SubarrayProductLessThanK {
    /* For each start position, we try to find the last end position, so that
    nums[start] * nums[start + 1] * ... * nums[end] < k
    And then add (end - start + 1) to return value.
    In this method, neither start nor end moves backwards (from right to left),
    so the time complexity is O(2*n) = O(n)
    Important note: remember to update the product at the end of the loop only if the current
    longest subarray is not empty ( i.e. end >= start).
*/
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int ret = 0;
        int start = 0, end = -1, product = 1;
        for ( ; start < nums.length; start ++) {
            end = (end < start)? (start - 1) : end;
            while (end < nums.length - 1 && product * nums[end+1] < k) {
                product *= nums[end + 1];
                end ++;
            }
            ret += end - start + 1;
            if(end >= start)
                product /= nums[start];
        }
        return ret;
    }
}
