package leetcode_in_java;

/**
 * Created by bopang on 18/3/15.
 */
public class LongestPalindromicSubstring {

    // Basic idea: try to find a general way to detect palindromic substrings with even or odd numbers.
    // When radius is odd, palindromic string of even length could be found; similarly, even radius deal with odd substrings.
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0)
            return "";
        int maxRadius = 0, maxCenterIdx = 0;
        int radius, centerIdx = 1;
        for(; centerIdx < 2 * s.length(); centerIdx += 2) {
            radius = 1;
            while( (centerIdx - radius >= 0) && (centerIdx + radius < 2 * s.length()) ) {
                if (s.charAt((centerIdx - radius) >> 1) != s.charAt((centerIdx + radius) >> 1))
                    break;
                radius += 2;
            }
            if (radius - 2 > maxRadius) {
                maxRadius = radius - 2;
                maxCenterIdx = centerIdx;
            }

            radius = 2;
            while( (centerIdx - radius >= 0) && (centerIdx + radius < 2 * s.length()) ) {
                if (s.charAt((centerIdx - radius) >> 1) != s.charAt((centerIdx + radius) >> 1))
                    break;
                radius += 2;
            }
            if (radius - 2 > maxRadius) {
                maxRadius = radius - 2;
                maxCenterIdx = centerIdx;
            }
        }
        return s.substring( (maxCenterIdx - maxRadius) >> 1, ((maxCenterIdx + maxRadius) >> 1) + 1);
    }
}
