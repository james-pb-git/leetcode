package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    private int[] preprocess(String needle) {
        int[] res = new int[needle.length()];
        res[0] = -1;

    }

    public int strStr(String haystack, String needle) {
        if (null == haystack || haystack.length() == 0 ||
                null == needle || needle.length() == 0)
            return -1;
        int[] next = preprocess(needle);

    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();
    }
}