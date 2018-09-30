package pers.leetcode.contests;
import pers.leetcode.utils.*;

/**
 * Created by bopang on 18/7/31.
 */
public class Contest95 {
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
}
