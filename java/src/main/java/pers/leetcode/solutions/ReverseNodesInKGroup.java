package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/27.
 */
public class ReverseNodesInKGroup {
    private ListNode reverseLinkedListGivenLength( ListNode head, int length ) {
        if( length <= 1 || null == head || null == head.next )
            return head;

        ListNode prevNode = head;
        ListNode curNode = head.next;
        ListNode nextNode = head.next.next;
        head.next = null;

        int curStep = 2;
        while( curStep < length && nextNode != null ) {
            curNode.next = prevNode;

            prevNode = curNode;
            curNode = nextNode;

            nextNode = nextNode.next;
            curStep ++;
        }
        curNode.next = prevNode;
        return curNode;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if( k <= 1 || null == head || null == head.next )
            return head;

        ListNode res = null;
        ListNode preHead = null;
        ListNode curHead = head;
        ListNode curTail = head;

        boolean firstGroup = true;

        int curStep = 1;
        while( true ) {
            if( curStep < k ) {
                if( null != curTail.next ) {
                    curTail = curTail.next;
                    curStep ++;
                }
                else {
                    if( firstGroup ) {
                        res = curHead;
                    }
                    else {
                        preHead.next = curHead;
                    }
                    break;
                }
            }
            else {
                if( firstGroup ) {
                    res = curTail;
                    firstGroup = false;
                }
                else {
                    preHead.next = curTail;
                }
                preHead = curHead;
                curTail = curTail.next;
                curHead = curTail;
                reverseLinkedListGivenLength( preHead, k );
                if( null == curTail )
                    break;
                curStep = 1;
            }
        }
        return res;
    }
}
