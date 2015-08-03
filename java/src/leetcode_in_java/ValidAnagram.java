package leetcode_in_java;

import java.util.Arrays;

/**
 * Created by bopang on 15/8/1.
 */
class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if( null == s && null == t )
            return true;
        else if( null == s || null == t )
            return false;

        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        System.out.println(arrS);
        System.out.println( arrT );
        return Arrays.equals( arrS, arrT );
    }
}
