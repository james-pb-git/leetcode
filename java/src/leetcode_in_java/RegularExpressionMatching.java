package leetcode_in_java;

/**
 * Created by bopang on 18/3/18.
 */
public class RegularExpressionMatching {
    private boolean isMatchRecursive(String s, int idx1, String p, int idx2) {

        if (idx2 < p.length() - 1 && p.charAt(idx2 + 1) == '*')
            return isMatchRecursive(s, idx1, p, idx2 + 1);
        if (idx1 == s.length() && idx2 == p.length())
            return true;
        if (idx2 == p.length() || (idx1 == s.length() && p.charAt(idx2) != '*'))
            return false;

        if (p.charAt(idx2) == '*') {
            if (isMatchRecursive(s, idx1, p, idx2 + 1))
                return true;
            if (idx1 == s.length())
                return false;
            int tmpIdx = 0;
            while ((p.charAt(idx2 - 1) == '.') || s.charAt(idx1 + tmpIdx) == p.charAt(idx2 - 1)) {
                if (isMatchRecursive(s, idx1 + tmpIdx + 1, p, idx2 + 1))
                    return true;
                tmpIdx ++;
                if (idx1 + tmpIdx == s.length())
                    return false;
            }
        }
        if (p.charAt(idx2) == '.' || s.charAt(idx1) == p.charAt(idx2))
            return isMatchRecursive(s, idx1 + 1, p, idx2 + 1);
        return false;
    }

    public boolean isMatch(String s, String p) {
        if (null == s && null == p)
            return true;
        if (null == s || null == p)
            return false;
        return isMatchRecursive(s, 0, p, 0);
    }
}
