package leetcode_in_java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bopang on 15/8/5.
 */
class ContainsDuplicate {
    public boolean containsDuplicateSolutionI(int[] nums) {
        if( null == nums || 0 == nums.length )
            return false;
        Arrays.sort(nums);
        int prev = nums[0];
        for( int idx = 1; idx < nums.length; idx ++ )
        {
            if( nums[idx] == prev )
                return true;
            prev = nums[idx];
        }
        return false;
    }

    public boolean containsDuplicateSolutionII(int[] nums) {
        if( null == nums || 0 == nums.length )
            return false;
        Set<Integer> setValue = new HashSet<Integer>();
        for( int ele : nums ) {
            if( setValue.contains( ele ) )
                return true;
            setValue.add( ele );
        }
        return false;
    }
}
