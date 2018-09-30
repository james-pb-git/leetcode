package pers.leetcode.solutions;

/**
 * Created by bopang on 18/8/3.
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = -1, total = 0;
        for (int ele : piles) {
            total += ele;
            if (ele > maxVal)
                maxVal = ele;
        }

        // Notice: left is not necessarily 1.
        int left = (total-1)/H+1, right = maxVal, mid, midVal;
        while (left < right) {
            mid = left + (right - left) / 2;
            midVal = 0;
            for (int ele : piles) {
                // Notice: useful technique: accelerate ceil.
                // midVal += Math.ceil((ele + 0.0) / mid);
                midVal += (ele - 1) / mid + 1;
            }
            if (midVal > H)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
