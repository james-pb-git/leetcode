package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/26.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoListsVersion1(ListNode l1, ListNode l2) {
        if( null == l1 )
            return l2;
        if( null == l2 )
            return l1;

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head, curNode;
        if( node1.val < node2.val ) {
            head = node1;
            node1 = node1.next;
        }
        else {
            head = node2;
            node2 = node2.next;
        }
        curNode = head;
        while( null != node1 && null != node2 ) {
            if( node1.val < node2.val ) {
                curNode.next = node1;
                curNode = curNode.next;
                node1 = node1.next;
            }
            else {
                curNode.next = node2;
                curNode = curNode.next;
                node2 = node2.next;
            }
        }
        if( null == node1 )
            curNode.next = node2;
        else
            curNode.next = node1;
        return head;
    }

    public ListNode mergeTwoListsVersion2(ListNode l1, ListNode l2) {
        if( null == l1 )
            return l2;
        if( null == l2 )
            return l1;

        ListNode head, curNode;
        if( l1.val < l2.val ) {
            head = l1;
            l1 = l1.next;
        }
        else {
            head = l2;
            l2 = l2.next;
        }
        curNode = head;
        while( null != l1 && null != l2 ) {
            if( l1.val < l2.val ) {
                curNode.next = l1;
                curNode = curNode.next;
                l1 = l1.next;
            }
            else {
                curNode.next = l2;
                curNode = curNode.next;
                l2 = l2.next;
            }
        }
        if( null == l1 )
            curNode.next = l2;
        else
            curNode.next = l1;
        return head;
    }

    public ListNode mergeTwoListsVersion3(ListNode l1, ListNode l2) {
        if( null == l1 )
            return l2;
        if( null == l2 )
            return l1;

        ListNode head = null, curNode = null;
        boolean firstNode = true;

        while( null != l1 && null != l2 ) {
            if( l1.val < l2.val ) {
                if( firstNode ) {
                    head = l1;
                    curNode = head;
                    firstNode = false;
                }
                else {
                    curNode.next = l1;
                    curNode = curNode.next;
                }
                l1 = l1.next;
            }
            else {
                if( firstNode ) {
                    head = l2;
                    curNode = head;
                    firstNode = false;
                }
                else {
                    curNode.next = l2;
                    curNode = curNode.next;
                }
                l2 = l2.next;
            }
        }
        if( null == l1 )
            curNode.next = l2;
        else
            curNode.next = l1;
        return head;
    }

    public ListNode mergeTwoListsVersion4(ListNode l1, ListNode l2) {

        ListNode head = null, curNode = null;
        boolean firstNode = true;

        while( null != l1 && null != l2 ) {

            if (firstNode) {
                head = (l1.val < l2.val) ? l1 : l2;
                curNode = head;
                firstNode = false;
            } else {
                curNode.next = (l1.val < l2.val) ? l1 : l2;
                curNode = curNode.next;
            }

            if (l1.val < l2.val)
                l1 = l1.next;
            else
                l2 = l2.next;
        }

        if( null == head )
            return ( null == l1 ) ? l2 : l1;

        curNode.next = ( null == l1 ) ? l2 : l1;
        return head;
    }
}
