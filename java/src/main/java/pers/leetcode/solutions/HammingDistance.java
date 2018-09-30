package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/19.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int diff = x ^ y;
        int res = 0;
        while (diff != 0) {
            res += 1;
            diff = diff & (diff - 1);
        }
        return res;
    }
}
