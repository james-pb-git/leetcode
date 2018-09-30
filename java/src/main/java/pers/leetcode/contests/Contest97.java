package pers.leetcode.contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bopang on 18/8/12.
 */
public class Contest97 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] splitedA = A.split("\\s+");
        String[] splitedB = B.split("\\s+");
        HashMap<String, Boolean> retMap = new HashMap<String, Boolean>();
        for (String word : splitedA) {
            if(word.length() > 0) {
                if (retMap.containsKey(word))
                    retMap.put(word, false);
                else
                    retMap.put(word, true);
            }
        }
        for (String word : splitedB) {
            if(word.length() > 0) {
                if (retMap.containsKey(word))
                    retMap.put(word, false);
                else
                    retMap.put(word, true);
            }
        }
        List<String> tmpRet = new ArrayList<String>();
        for (String word : retMap.keySet()) {
            if (retMap.get(word) == true)
                tmpRet.add(word);
        }
        String[] ret = new String[tmpRet.size()];
        for (int ind = 0; ind < tmpRet.size(); ind ++) {
            ret[ind] = tmpRet.get(ind);
        }
        return ret;
    }

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][2];
        ret[0][0] = r0;
        ret[0][1] = c0;

        int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int curDirection = 0;
        int step = 1;
        int[] curPos = new int[]{r0, c0};

        int resInd = 1;

        while (resInd < R * C) {
            for (int ind = 0; ind < step; ind ++) {
                curPos[0] += directions[curDirection][0];
                curPos[1] += directions[curDirection][1];
                if (0 <= curPos[0] && curPos[0] < R &&
                        0 <= curPos[1] && curPos[1] < C) {
                    ret[resInd][0] = curPos[0];
                    ret[resInd][1] = curPos[1];
                    resInd++;
                }
            }
            curDirection ++;
            if (curDirection == 4)
                curDirection = 0;
            for (int ind = 0; ind < step; ind ++) {
                curPos[0] += directions[curDirection][0];
                curPos[1] += directions[curDirection][1];
                if ( 0 <= curPos[0] && curPos[0] < R &&
                        0 <= curPos[1] && curPos[1] < C) {
                    ret[resInd][0] = curPos[0];
                    ret[resInd][1] = curPos[1];
                    resInd ++;
                }
            }
            curDirection ++;
            if (curDirection == 4)
                curDirection = 0;
            step ++;
        }
        return ret;
    }
}
