package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/6.
 */
class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if( null == head )
            return false;
        ListNode fastIter = head;
        ListNode slowIter = head;
        while( null != fastIter ) {
            fastIter = fastIter.next;
            if( null == fastIter )
                return false;
            fastIter = fastIter.next;

            slowIter = slowIter.next;
            if( fastIter == slowIter )
                return true;
        }
        return false;
    }
}
