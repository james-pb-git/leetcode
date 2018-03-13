package leetcode_in_java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bopang on 18/3/13.
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0)
            return 0;
        int start = 0, end = 0, len = 0, maxLen = 0;
        Set<Character> charFound = new HashSet<Character>();
        while (end < s.length()) {
            if (!charFound.contains(s.charAt(end))) {
                charFound.add(s.charAt(end));
                end ++;
                len ++;
                maxLen = (len > maxLen)? len : maxLen;
            }
            else {
                charFound.remove(s.charAt(start));
                start++;
                len--;
            }
        }
        return maxLen;
    }
}

