package leetcode_in_java;

import java.util.Arrays;

/**
 * Created by bopang on 18/8/5.
 */
public class Contest96 {
    public int projectionArea(int[][] grid) {

        int numRow = grid.length;
        int numCol = grid[0].length;
        int[] maxRow = new int[numRow];
        int[] maxCol = new int[numCol];
        int res = 0;

        for(int i = 0; i < numRow; i ++ ) {
            for (int j = 0; j < numCol; j ++) {
                res += (grid[i][j] > 0) ? 1 : 0;
                maxRow[i] = Math.max(maxRow[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        for(int ele : maxRow) {
            res += ele;
        }
        for (int ele : maxCol)
            res += ele;
        return res;
    }

    public int numRescueBoats(int[] people, int limit) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);
        int left = 0, right = sortedPeople.length - 1;
        int res = 0;
        while(left < right) {
            if (sortedPeople[left] + sortedPeople[right] <= limit) {
                left ++;
            }
            right --;
            res ++;
        }
        return (left == right) ? res + 1 : res;
    }

    private int binarySearch(long[] arrLen, int right, int K) {
        int left = 0, mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (arrLen[mid] >= K) {
                right = mid;
            }
            else
                left = mid + 1;
        }
        return left;
    }

    public String decodeAtIndex(String S, int K) {
        long[] lenSoFar = new long[S.length()];
        lenSoFar[0] = 1;
        for (int idx = 1; idx < S.length(); idx ++) {
            if(S.charAt(idx) >= '2' && S.charAt(idx) <= '9') {
                lenSoFar[idx] = lenSoFar[idx - 1] * (S.charAt(idx) - '0');
            }
            else
                lenSoFar[idx] = lenSoFar[idx - 1] + 1;
        }
        int idx, right = lenSoFar.length - 1;
        while (true) {
            idx = binarySearch(lenSoFar, right, K);
            if (S.charAt(idx) >= '2' && S.charAt(idx) <= '9') {
                K %= lenSoFar[idx - 1];
                if (K == 0)
                    K = (int) lenSoFar[idx - 1];
                right = idx - 1;
            }
            else
                return Character.toString(S.charAt(idx));
        }
    }
}
