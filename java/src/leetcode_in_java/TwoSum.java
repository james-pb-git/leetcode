package leetcode_in_java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bopang on 18/3/13.
 */
public class TwoSum {

    public int[] twoSumBruteForce(int[] nums, int target) {
        if (null == nums || nums.length < 2)
            return null;
        int[] res = new int[2];
        boolean found = false;
        int idx1 = 0, idx2 = 1;
        for (; idx1 < nums.length - 1; idx1++) {
            for (idx2 = idx1 + 1; idx2 < nums.length; idx2++) {
                if (nums[idx1] + nums[idx2] == target) {
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }
        res[0] = idx1;
        res[1] = idx2;
        return res;
    }

    public int[] twoSumHashOnePass(int[] nums, int target) {
        if (null == nums || nums.length < 2)
            return null;
        Map<Integer, Integer> requiredValue = new HashMap<Integer, Integer>();
        for(int idx = 0; idx < nums.length; idx ++) {
            if (requiredValue.containsKey(nums[idx]))
                return new int[]{requiredValue.get(nums[idx]), idx}; // Attention!
            else
                requiredValue.put(target - nums[idx], idx);
        }
        return null;
    }
}
