package pers.leetcode.solutions;

import java.util.*;

/**
 * Created by bopang on 18/3/31.
 */
public class ThreeSum {

    // Exceed time limit for some cases.
    public List<List<Integer>> threeSumTwoPass(int[] nums) {
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

    public List<List<Integer>> threeSumAccepted(int[] nums) {
        if (null == nums)
            return null;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int target_index = 0, target_value;
        int left, right;
        while (target_index < nums.length) {
            target_value = - nums[target_index];
            left = target_index + 1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target_value) {
                    left ++;
                    continue;
                }
                if (nums[left] + nums[right] > target_value) {
                    right --;
                    continue;
                }
                res.add(Arrays.asList(nums[target_index], nums[left], nums[right]));
                left ++; right --;
                while (left < right && nums[left - 1] == nums[left])
                    left ++;
                while (right > left && nums[right + 1] == nums[right])
                    right --;
            }
            target_index ++;
            while(target_index < nums.length - 1 && nums[target_index - 1] == nums[target_index])
                target_index ++;
        }
        return res;
    }
}
