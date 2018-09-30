package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/17.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefixSolution1(String[] strs) {
        if (null == strs || strs.length == 0)
            return "";
        int strIdx = 0, arrIdx;
        boolean finished = false;
        StringBuilder res = new StringBuilder();
        while (!finished) {
            for (arrIdx = 0; arrIdx < strs.length; arrIdx ++) {
                if ((strIdx > strs[arrIdx].length() - 1) ||
                        (arrIdx > 0 && strs[arrIdx].charAt(strIdx) != strs[arrIdx-1].charAt(strIdx))) {
                    finished = true;
                    break;
                }
            }
            if (finished)
                break;
            res.append(strs[0].charAt(strIdx++));
        }
        return new String(res);
    }

    public String longestCommonPrefixSolution2(String[] strs) {
        if (null == strs || strs.length == 0)
            return "";
        int strIdx = 0, arrIdx;
        StringBuilder res = new StringBuilder();
        while (true) {
            for (arrIdx = 0; arrIdx < strs.length; arrIdx ++) {
                if ((strIdx > strs[arrIdx].length() - 1) ||
                        (arrIdx > 0 && strs[arrIdx].charAt(strIdx) != strs[arrIdx-1].charAt(strIdx)))
                    return new String(res);
            }
            res.append(strs[0].charAt(strIdx++));
        }
    }

    public String longestCommonPrefixSolution3(String[] strs) {
        if (null == strs || strs.length == 0)
            return "";
        String res = strs[0];
        for (int arrIdx = 1; arrIdx < strs.length; arrIdx ++) {
            while (strs[arrIdx].indexOf(res) != 0)
                res = res.substring(0, res.length() - 1);
            if (res.length() == 0)
                return "";
        }
        return res;
    }
}
