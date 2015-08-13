package leetcode_in_java;

/**
 * Created by bopang on 15/8/6.
 */
class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if( null == s || 0 == s.length() )
            return 0;
        int ans = 0;
        int base = 1;
        char[] arrStr = s.toCharArray();
        for( int idx = arrStr.length - 1; idx >= 0; idx -- ) {
            ans += ( arrStr[ idx ] - 'A' + 1 ) * base;
            base *= 26;
        }
        return ans;
    }
}
