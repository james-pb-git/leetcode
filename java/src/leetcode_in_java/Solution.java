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

    private List<Integer> accWeight = new ArrayList<Integer>();
    public Solution(int[] w) {
        int curAcc = 0;
        for (int ele : w) {
            curAcc += ele;
            accWeight.add(curAcc);
        }
    }

    public int pickIndex() {
        double randomVal = Math.random() * this.accWeight.get(accWeight.size() - 1);
        int left = 0, right = this.accWeight.size() - 1, mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (randomVal <= accWeight.get(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        int[] w = new int[]{1,3};
        Solution solution = new Solution(w);
        for (int i = 0; i < 50; i++)
            System.out.println(solution.pickIndex());

        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println(duration);
    }
}


