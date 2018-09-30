package pers.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 8/16/18.
 */
public class SplitArrayIntoFibonacciSeq {

    /* Important notes:
    1) Use long to detect overflow, the logic will be much simpler than using int variable.
    2) Accelerate searching by early termination.
    */

    private boolean splitStringRecursiveImproved(String s, int start, List<Integer> ret) {
        if (start == s.length())
            return false;

        int expectedNum;
        long curNum;
        for (int ind = start; ind < s.length(); ind ++) {
            curNum = Long.valueOf(s.substring(start, ind + 1));

            // Overflow detection
            if(curNum > Integer.MAX_VALUE)
                break;

            if(ret.size() <= 1) {
                ret.add( (int) curNum);
                if(splitStringRecursive(s, ind + 1, ret))
                    return true;
                ret.remove(ret.size() - 1);
            }
            else {
                expectedNum = ret.get(ret.size() - 1) + ret.get(ret.size() - 2);
                if (curNum == expectedNum) {
                    ret.add( (int) curNum );
                    if (ind == s.length() - 1)
                        return true;
                    if (splitStringRecursive(s, ind + 1, ret))
                        return true;
                    ret.remove(ret.size() - 1);
                }
                // Early termination
                else if(curNum > expectedNum)
                    break;
            }
            // Leading zero process
            if (ind == start && s.charAt(ind) == '0')
                break;
        }
        return false;
    }

    private boolean splitStringRecursive(String s, int start, List<Integer> ret) {
        if (start == s.length())
            return false;

        int expectedNum;
        long curNum;
        if (ret.size() <= 1) {
            for(int ind = start; ind < s.length(); ind ++) {

                curNum = Long.valueOf(s.substring(start, ind + 1));

                // Overflow detection
                if(curNum > Integer.MAX_VALUE)
                    break;
                /*if ((ind > start) &&
                    (Integer.valueOf(s.substring(start, ind)) > Integer.MAX_VALUE / 10 ||
                    ((Integer.valueOf(s.substring(start, ind)) == Integer.MAX_VALUE / 10) &&
                    s.charAt(ind) > Integer.MAX_VALUE % 10)))
                    break;*/

                ret.add((int) curNum);
                if(splitStringRecursive(s, ind + 1, ret))
                    return true;
                ret.remove(ret.size() - 1);
                // deal with leading zero
                if (s.charAt(start) == '0' && ind == start)
                    break;
            }
        }
        else {
            expectedNum = ret.get(ret.size() - 1) + ret.get(ret.size() - 2);
            for(int ind = start; ind < s.length(); ind ++) {

                curNum = Long.valueOf(s.substring(start, ind + 1));

                // Overflow detection
                if(curNum > Integer.MAX_VALUE)
                    break;
                /*if ((ind > start) &&
                    (Integer.valueOf(s.substring(start, ind)) > Integer.MAX_VALUE / 10 ||
                    ((Integer.valueOf(s.substring(start, ind)) == Integer.MAX_VALUE / 10) &&
                    s.charAt(ind) > Integer.MAX_VALUE % 10)))
                    break;*/

                if((int) curNum == expectedNum) {
                    ret.add((int) curNum);
                    if (ind + 1 == s.length())
                        return true;
                    if (splitStringRecursive(s, ind + 1, ret))
                        return true;
                    ret.remove(ret.size() - 1);
                }
                if (s.charAt(start) == '0' && ind == start)
                    break;
            }
        }
        return false;
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<Integer>();
        splitStringRecursive(S, 0, ret);
        return ret;
    }
}
