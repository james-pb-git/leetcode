package pers.leetcode.solutions;

/**
 * Created by bopang on 18/3/13.
 */

import pers.leetcode.utils.*;

public class AddTwoNumbers {

    public ListNode addTwoNumbersSolution1(ListNode l1, ListNode l2) {
        boolean carry = (l1.val + l2.val) > 9;
        ListNode res = new ListNode(carry ? (l1.val + l2.val - 10) : (l1.val + l2.val));
        ListNode cur = res;
        while (l1.next != null || l2.next != null || carry) {
            int digit = 0;
            if (l1.next != null) {
                l1 = l1.next;
                digit += l1.val;
            }
            if (l2.next != null) {
                l2 = l2.next;
                digit += l2.val;
            }
            if(carry)
                digit += 1;
            if (digit > 9) {
                carry = true;
                digit -= 10;
            }
            else
                carry = false;
            cur.next = new ListNode(digit);
            cur = cur.next;
        }
        return res;
    }

    public ListNode addTwoNumbersSolution2(ListNode l1, ListNode l2) {
        int digit = 0;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null || l2 != null) {
            digit = digit / 10;
            if (l1 != null) {
                digit += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                digit += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(digit % 10);
            cur = cur.next;
        }
        if (digit > 9)
            cur.next = new ListNode(1);
        return res.next;
    }
}
