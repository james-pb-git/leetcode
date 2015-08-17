package leetcode_in_java;

/**
 * Created by bopang on 15/8/14.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        char[] romanMap = new char[]{ 'I', 'V', 'X', 'L', 'C', 'D',  'M' };
        int[]  numMap = new int[]{     1 ,  5 ,  10,  50, 100, 500, 1000 };
        int romanSize = romanMap.length;

        String ans = "";
        while( num > 0 ) {
            int idx = romanSize - 1;
            for( ; idx >= 0; idx -- ) {
                if( numMap[ idx ] <= num )
                    break;
            }

            // I, X, C, M
            if( idx % 2 == 0 ) {
                if( num >= 4 * numMap[ idx ] ) {
                    ans += String.valueOf( romanMap[ idx ] )+ String.valueOf( romanMap[ idx + 1 ]);
                    num -= 4 * numMap[ idx ];
                }
                else {
                    ans += romanMap[idx];
                    num -= numMap[idx];
                }
            }
            // V, L, D
            else {
                if( num >= numMap[ idx ] / 5 * 9 ) {
                    ans += String.valueOf( romanMap[ idx - 1 ] )+ String.valueOf( romanMap[ idx + 1 ]);
                    num -= numMap[ idx ] / 5 * 9;
                }
                else  {
                    ans += romanMap[idx];
                    num -= numMap[idx];
                }
            }
        }
        return ans;
    }
}
