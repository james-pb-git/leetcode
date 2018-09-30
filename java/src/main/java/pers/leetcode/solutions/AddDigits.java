package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/17.
 */
class AddDigits {
    public int addDigits(int num) {
        if( 0 == num )
            return 0;
        int ans = num % 9;
        if( 0 == ans )
            return 9;
        return ans;
    }
}
