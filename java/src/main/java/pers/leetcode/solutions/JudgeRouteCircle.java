package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/20.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int [] countDirections = new int[]{0, 0, 0, 0}; // counters for U D L R
        for (char c: moves.toCharArray()) {
            switch (c) {
                case 'U': countDirections[0] ++; break;
                case 'D': countDirections[1] ++; break;
                case 'L': countDirections[2] ++; break;
                case 'R': countDirections[3] ++;
            }
        }
        return (countDirections[0] == countDirections[1]) &&
                (countDirections[2] == countDirections[3]);
    }
}
