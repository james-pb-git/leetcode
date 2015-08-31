package leetcode_in_java;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bopang on 15/8/14.
 */
class RomanToInteger {
    static Map<Character, Integer > mapRomanToNum = new HashMap<Character, Integer>();
    static {
        mapRomanToNum.put( 'I', 1 );
        mapRomanToNum.put( 'V', 5 );
        mapRomanToNum.put( 'X', 10 );
        mapRomanToNum.put( 'L', 50 );
        mapRomanToNum.put( 'C', 100 );
        mapRomanToNum.put( 'D', 500 );
        mapRomanToNum.put( 'M', 1000 );
    }

    public int romanToInt(String s) {
        if( null == s || s.length() == 0 )
            return 0;
        char[] arrCh = s.toCharArray();
        int ans = 0;
        for( int idx = 0; idx < arrCh.length; idx ++ ) {
            int curValue = mapRomanToNum.get( Character.valueOf( arrCh[ idx ] ) );
            int nextValue = -1;
            if( idx < arrCh.length - 1 )
                nextValue = mapRomanToNum.get( Character.valueOf( arrCh[ idx + 1 ] ));

            if( curValue < nextValue ) {
                ans += nextValue - curValue;
                idx ++;
            }
            else
                ans += curValue;
        }
        return ans;
    }
}
