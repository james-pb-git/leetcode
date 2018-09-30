package pers.leetcode.solutions;

/**
 * Created by bopang on 18/8/3.
 */
public class BinaryGap {
    public int binaryGap(int N) {
        int maxGap = 0, curGap = 0;
        while ((N & 1) == 0)
            N = N >> 1;
        while (N > 0) {
            maxGap = Math.max(maxGap, curGap);
            if ((N & 1) == 1)
                curGap = 0;
            N = N >> 1;
            curGap ++;
        }
        return maxGap;
    }
}
