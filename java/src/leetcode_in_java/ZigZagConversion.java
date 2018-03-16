package leetcode_in_java;

/**
 * Created by bopang on 18/3/16.
 */
public class ZigZagConversion {
    /* numRows = 5, cycleLength = 8, numCycles = 2, remainder = 6
0       8           16
1     7 9        15 17
2   6   10    14    18
3 5     11 13       19 21
4       12          20
*/
    public String convert(String s, int numRows) {
        if (null == s || s.length() == 0 || numRows <= 1)
            return s;
        StringBuilder res = new StringBuilder();
        int cycleLength = 2 * numRows - 2;
        int numCycles = s.length() / cycleLength;
        int remainder = s.length() % cycleLength;

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int cycleIdx = 0; cycleIdx < numCycles; cycleIdx++) {
                res.append(s.charAt(rowIdx + cycleIdx * cycleLength));
                if (rowIdx != 0 && rowIdx != numRows - 1)
                    res.append(s.charAt((cycleLength - rowIdx) + cycleIdx * cycleLength));
            }
            if (remainder - 1 >= rowIdx )
                res.append(s.charAt(rowIdx + numCycles * cycleLength));
            if (rowIdx != 0 && rowIdx != numRows - 1 && remainder - 1 >= cycleLength - rowIdx)
                res.append(s.charAt((cycleLength - rowIdx) + numCycles * cycleLength));
        }
        return new String(res);
    }
}
