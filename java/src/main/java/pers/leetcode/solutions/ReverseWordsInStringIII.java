package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/20.
 */
public class ReverseWordsInStringIII {
    public String reverseWordsSolution1(String s) {
        if (null == s) return null;
        String res = new String();
        StringBuilder tmpStr = new StringBuilder();
        int idx = s.length() - 1;
        boolean lastWord = true;
        while (idx >= -1) {
            if (idx == -1 || s.charAt(idx) == ' ') {
                res = new String(tmpStr) + (lastWord? "" : " " ) + res;
                lastWord = false;
                tmpStr.setLength(0);
            }
            else
                tmpStr.append(s.charAt(idx));
            idx --;
        }
        return res;
    }

    /* convert string to chararray, so that it can be processed in place. */
    public String reverseWordsSolution2(String s) {
        if (null == s) return null;
        char[] str = s.toCharArray();
        int start = 0, end;
        for (end = 0; end <= str.length; end ++) {
            if (end == str.length || str[end] == ' ') {
                reverseSingleWord(str, start, end - 1);
                start = end + 1;
            }
        }
        return new String(str);
    }
    private void reverseSingleWord(char[] str, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = str[start];
            str[start++] = str[end];
            str[end--] = tmp;
        }
    }
}
