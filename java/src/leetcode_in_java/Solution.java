package leetcode_in_java;
import apple.laf.JRSUIUtils;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        return 0;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next;
        }
        return slow;
    }

    public boolean stoneGame(int[] piles) {
        return true;
    }

    private int gcd (int A, int B) {
        if (A > B)
            return gcd(B, A);
        int tmp;
        while(A > 0) {
            tmp = B % A;
            B = A;
            A = tmp;
        }
        return B;
    }

    private int lcm(int A, int B) {
        return A * B / gcd(A, B);
    }

    private int findM(int N, int A, int B, int MaxAns) {
        int left = 1, right = MaxAns, mid, cntMid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            cntMid = mid / A + mid / B - mid / lcm(A, B);
            if (cntMid >= N)
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public int nthMagicalNumber(int N, int A, int B) {
        int MaxAns = 1000000007;
        int UnitCount = MaxAns / A + MaxAns / B - MaxAns / (lcm(A, B));
        if (N <= UnitCount)
            return findM(N, A, B, MaxAns);
        double k = N / (UnitCount + 0.5);
        N = N - (int) Math.floor(k);
        return findM(N, A, B, MaxAns);
    }

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();

        long startTime = System.nanoTime();
        int num = solution.nthMagicalNumber(1, 2, 3);
        long endTime = System.nanoTime();
        System.out.println(num);
        long duration = (endTime - startTime) / 1000000;
        System.out.println(duration);
    }
}


