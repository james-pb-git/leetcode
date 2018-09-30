package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/20.
 */
public class NumberComplement {
    public int findComplement(int num) {
        int complement = 0;
        int base = 1;
        while (num > 0) {
            if (num == (num >> 1 << 1)) {
                complement += base;
            }
            num = (num >> 1);
            base *= 2;
        }
        return complement;
    }
}
