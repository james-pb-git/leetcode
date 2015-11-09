package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    public int findDuplicate(int[] nums) {

        if( null == nums || 0 == nums.length )
            return 0;
        if( 1 == nums.length )
            return nums[ 0 ];swap

        int len = nums.length;
        int N = len - 1;

        int left = 0;
        int right = N;
        int mid, cntMid;
        while( left <= right ) {
            mid = left + ( right - left ) / 2;
            cntMid = 0;
            for( int idx = 0; idx < len; idx ++ ) {
                if (nums[idx] < mid)
                    cntMid++;
            }
            if( cntMid < len / 2 )
                left = mid + 1;
            if( cntMid > len / 2 )
                right = mid - 1;
        }

    }

   public static void main( String args[] ) {
       System.out.println("Hello Leetcode");
       Solution solution = new Solution();
    }
}