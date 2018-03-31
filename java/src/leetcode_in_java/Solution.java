package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = solution.threeSum(nums);
        for (List<Integer> ans: res) {
            System.out.println(ans);
        }
    }
}