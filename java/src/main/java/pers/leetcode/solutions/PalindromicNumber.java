package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/16.
 */
public class PalindromicNumber {

    /* Notice: if x is palindromic, reversing it wouldn't cause overflow, because x itself hasn't overflowed.
    In other words, if we get y by reversing x, and find x != y, then it's sure that x isn't palindromic.
    (Even though overflow happens during the reversing operation)
    */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int reversedX = 0, originalX = x;
        while (x > 0) {
            reversedX = reversedX * 10 + (x % 10);
            x /= 10;
        }
        return (reversedX == originalX);
    }

    public boolean isPalindromeImproved(int x) {
        if ((x < 0) || (x > 0) && (x % 10 == 0))
            return false;
        int reversedX = 0;
        while (x > reversedX) {
            reversedX = reversedX * 10 + (x % 10);
            x /= 10;
        }
        return (reversedX == x || reversedX / 10 == x);
    }
}
