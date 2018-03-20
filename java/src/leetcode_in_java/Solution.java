package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    // Two pass solution.
    public List<List<Integer>> threeSum(int[] nums) {
        if (null == nums || nums.length < 3)
            return new ArrayList<List<Integer>>();
        Map<Integer, Set<Set<Integer>>> valueMap = new HashMap<Integer, Set<Set<Integer>>>();
        int tmpSum = 0;
        for (int idx1 = 0; idx1 <= nums.length - 2; idx1 ++) {
            for (int idx2 = idx1 + 1; idx2 <= nums.length - 1; idx2++) {
                tmpSum = nums[idx1] + nums[idx2];
                if (!valueMap.containsKey(-tmpSum))
                    valueMap.put(-tmpSum, new HashSet<Set<Integer>>());
                valueMap.get(-tmpSum).add(new HashSet<Integer>(Arrays.asList(idx1, idx2)));
            }
        }

        Set<List<Integer>> resSet = new HashSet<List<Integer>>();
        List<Integer> tmpList;
        for (int idx = 0; idx <= nums.length - 1; idx ++) {
            if (valueMap.containsKey(nums[idx])) {
                for( Set<Integer> set : valueMap.get(nums[idx])) {
                    if (!set.contains(idx)) {
                        tmpList = new ArrayList<Integer>();
                        tmpList.add(nums[idx]);
                        for (Integer resIdx: set)
                            tmpList.add(nums[resIdx]);
                        Collections.sort(tmpList);
                        resSet.add(tmpList);
                    }
                }
            }
        }
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (List<Integer> triplets: resSet)
            res.add(triplets);
        return res;
    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();
    }
}