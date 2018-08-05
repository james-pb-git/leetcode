package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        return 0;
    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();

        int[] a = new int[]{1,2,3};
        a[2] = 4;
        Integer[] intArr = new Integer[]{4,5,6};
        intArr[2] = 5;

        String[] strArr = new String[]{"abc", "ded", "sdf"};
        strArr[2] = "Asdf";
        System.out.println(Arrays.toString(strArr));


        String[][] arr = new String[][]{{"abc", "dvd"}, {"def"}};
        arr[0][1] = "abc";
        System.out.println(arr[1]);
        System.out.println(arr[0][1]);

        String[] cloneOfArray = Arrays.copyOf(arr[0], 2);
        System.out.println(arr[0]);
        System.out.println(cloneOfArray[0]);

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println(duration);
    }
}


