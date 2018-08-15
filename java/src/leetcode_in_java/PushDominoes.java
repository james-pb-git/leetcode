package leetcode_in_java;

/**
 * Created by bopang on 18/8/15.
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] arrDominoes = dominoes.toCharArray();
        int start = 0, end = 0, tmpStart, tmpEnd;
        boolean toRight, toLeft;
        while (start < arrDominoes.length) {

            // Move two pointers, so that they are the start and end of a continuous subsequence of '.'
            while (start < arrDominoes.length && arrDominoes[start] != '.')
                start ++;
            end = start;
            while (end < arrDominoes.length && arrDominoes[end] == '.')
                end ++;
            end --;

            // Decide whether dominoes in between need to falling to right or left.
            toRight = false;
            toLeft = false;
            if (start > 0 && arrDominoes[start - 1] == 'R')
                toRight = true;
            if (end < arrDominoes.length - 1 && arrDominoes[end + 1] == 'L')
                toLeft = true;

            // Change the status of dominoes in between.
            tmpStart = start;
            tmpEnd = end;
            if (toRight && toLeft) {
                while (tmpStart < tmpEnd) {
                    arrDominoes[tmpStart++] = 'R';
                    arrDominoes[tmpEnd--] = 'L';
                }
            }
            else if(toRight) {
                while(tmpStart <= end)
                    arrDominoes[tmpStart++] = 'R';
            }
            else if(toLeft) {
                while(tmpEnd >= start)
                    arrDominoes[tmpEnd--] = 'L';
            }

            start = end + 1;
        }
        return new String(arrDominoes);
    }
}
