package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    private double findMedianRecursive(int[] nums1, int[] nums2,
                                       int start1, int end1,
                                       int start2, int end2,
                                       int target) {
        int []tmpRes = new int[2];
        if (start1 > end1) {
            tmpRes[0] = nums2[start2 + target];
            tmpRes[1] = nums2[start2 + target + 1];
        }
        if (start2 < end2) {
            tmpRes[0] = nums1[start1 + target];
            tmpRes[1] = nums1[start1 + target + 1];
        }
        


    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2)
            return 0.0;
        return findMedianRecursive(nums1, nums2,
                0, nums1.length - 1,
                0, nums2.length - 1,
                (nums1.length + nums2.length - 1) >> 1);

    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();
        String testString = new String("abcdabc");
//        System.out.println(solution.lengthOfLongestSubstring(testString));
    }
}