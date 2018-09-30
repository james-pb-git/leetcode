package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/25.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if( null == head )
            return null;
        if( null == head.next )
            return head;
        ListNode prevNode = head;
        ListNode curNode = head.next;
        ListNode nextNode = head.next.next;
        head.next = null;

        while( nextNode != null ) {
            curNode.next = prevNode;

            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        curNode.next = prevNode;
        return curNode;
    }
}
