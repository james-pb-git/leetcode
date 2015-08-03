package leetcode_in_java;

/**
 * Created by bopang on 15/8/1.
 */
class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
