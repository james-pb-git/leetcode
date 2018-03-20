package leetcode_in_java;

/**
 * Created by bopang on 18/3/20.
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        return (A.length() == B.length()) && ((A + A).indexOf(B) >= 0);
    }
}
