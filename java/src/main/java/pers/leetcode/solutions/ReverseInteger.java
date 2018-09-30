package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/16.
 */
public class ReverseInteger {

    public int reverseSolution1(int x) {
        int res = 0;
        if (x >= 0) {
            while (x > 0) {
                if ((Integer.MAX_VALUE - (x - x / 10 * 10)) / 10 >= res)
                    res = res * 10 + (x - x / 10 * 10);
                else
                    return 0;
                x = x / 10;
            }
            return res;
        }
        else {
            while (x < 0) {
                if (((Integer.MIN_VALUE - (x - x / 10 * 10)) / 10 <= res))
                    res = res * 10 + (x - x / 10 * 10);
                else
                    return 0;
                x = x / 10;
            }
        }
        return res;
    }

    public int reverseSolution2(int x) {
        int res = 0, lastDigit = 0;
        while (x != 0) {
            lastDigit = x % 10; // For negative x, this last digit is also negative.
            if (((x > 0) && ((Integer.MAX_VALUE - lastDigit) / 10 >= res)) ||
                    ((x < 0) && ((Integer.MIN_VALUE - lastDigit) / 10 <= res)))
                res = res * 10 + lastDigit;
            else
                return 0;
            x = x / 10;
        }
        return res;
    }
}
