package pers.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 18/8/3.
 */
public class RandomPickWithWeight {

    // ----------- Solution 1 ----------------
    private List<Integer> boundaries;
    private int upper_boundary;

    public RandomPickWithWeight(int[] w) {
        boundaries = new ArrayList<Integer>();
        int cur_sum = 0;
        for(int ele: w) {
            cur_sum += ele;
            boundaries.add(cur_sum);
        }
        upper_boundary = cur_sum;
    }

    public int pickIndex() {
        int randomInt = (int) Math.floor(Math.random() * upper_boundary);
        int left = -1, right = boundaries.size() - 1, mid, midVal;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            midVal = (mid == -1) ? 0 : boundaries.get(mid);
            if (randomInt <= midVal)
                right = mid;
            else
                left = mid + 1;
        }
        int resVal = (left == -1) ? 0 : boundaries.get(left);
        return (resVal <= randomInt) ? left + 1 : left;
    }

    // ----------- Solution 2 ----------------
    /* Improvement:
       Simplify the logic of binary search.
       Notice that, after the while loop, only two situation could exist:
       1) accWeight[right] == accWeight[left] == randomInt
       2) accWeight[right] == accWeight[left] > randomInt, and randomInt doesn't exist in accWeight.
       Based on that, the only thing we need to do is to change the return value when the case is 1).
       Take w = [1,3] as an example: accWeight would be [1,4], randomInt could be 0, 1, 2, 3.
       0 -> 0
       1 -> 1 (not 0, as the ending status of while loop)
       2 -> 1
       3 -> 1
     */

    private List<Integer> accWeight = new ArrayList<Integer>();
    public RandomPickWithWeight(int[] w, int thisIsSol2) {
        int curAcc = 0;
        for (int ele : w) {
            curAcc += ele;
            accWeight.add(curAcc);
        }
    }

    public int pickIndexSol2() {
        int randomInt = (int) (Math.random() * this.accWeight.get(accWeight.size() - 1));
        int left = 0, right = this.accWeight.size() - 1, mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (randomInt <= accWeight.get(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return (this.accWeight.get(left) == randomInt) ? left + 1 : left;
    }

    // ----------- Solution 3 ----------------
    /* Improvement:
    Use random double value instead of random int., In this way,
    what to return when randomVal equals to one of the elements of accWeight is no longer important,
    since double values are dense, and the probability of random value being equal to a certain value is 0.
     */
    // private List<Integer> accWeight = new ArrayList<Integer>();
    public RandomPickWithWeight(int[] w, boolean thisIsSol3) {
        int curAcc = 0;
        for (int ele : w) {
            curAcc += ele;
            accWeight.add(curAcc);
        }
    }

    public int pickIndexSol3() {
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
}
