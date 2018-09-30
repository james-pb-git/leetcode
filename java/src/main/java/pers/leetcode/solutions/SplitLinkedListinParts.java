package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 18/8/9.
 */
public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];

        if (root == null)
            return res;

        ListNode cur = root;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len += 1;
        }
        int lenOfLongParts = len / k + 1;
        int numOfLongParts = len % k;

        ListNode start = root, end = root;
        for (int ind = 0; ind < numOfLongParts; ind ++) {
            for (int step = 0; step < lenOfLongParts - 1; step ++)
                end = end.next;
            res[ind] = start;
            start = end.next;
            end.next = null;
            end = start;

        }
        for (int ind = 0; ind < k - numOfLongParts; ind ++) {
            if (lenOfLongParts == 1) {
                res[numOfLongParts + ind] = null;
                continue;
            }
            for (int step = 0; step < lenOfLongParts - 2; step ++)
                end = end.next;
            res[numOfLongParts + ind] = start;
            if (end != null) {
                start = end.next;
                end.next = null;
            }
            end = start;
        }
        return res;
    }

    /* ------------- Solution 2 -----------------------------
    Improvements:
    1) Check whether end == null in the condition part of for loop, so that the loop will end
       automatically when we reach the end of linked list; this way we don't need to do this inside
       the loop.
    2) Merge the logic of long parts and short parts, ending up with a little bit more complicated
       for loop condition step < lenOfLongParts - ((ind < numOfLongParts) ? 1 : 2).
    Important notes: the difficulty of this problem is to deal with edge cases. This solution is a
    clean way to do that.
     */
    public ListNode[] splitListToPartsSol(ListNode root, int k) {
        ListNode[] ret = new ListNode[k];
        int len = 0;
        ListNode node = root;
        while (node != null) {
            len ++;
            node = node.next;
        }
        int lenOfLongParts = len / k + 1;
        int numOfLongParts = len % k;
        ListNode start = root, end = root;
        for (int ind = 0; end != null && ind < len; ind ++) {
            for (int step = 0; step < lenOfLongParts - ((ind < numOfLongParts) ? 1 : 2); step ++)
                end = end.next;
            ret[ind] = start;
            start = end.next;
            end.next = null;
            end = start;
        }
        return ret;
    }

}
