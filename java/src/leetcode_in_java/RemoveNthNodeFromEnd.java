package leetcode_in_java;

/**
 * Created by bopang on 18/4/2.
 */
public class RemoveNthNodeFromEnd {
    /*
    No dummy node, so need to deal with the case when n == len(linkedlist)
    Generally, slow is the node before the node to delete.
    There are n steps between fast and slow.
     */
    public ListNode removeNthFromEndSol1(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int idx = 0; idx < n; idx ++) {
            if(fast != null)
                fast = fast.next;
            else
                return head;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /*
    Since given is always valid, as stated in the problem, there's no need to check "fast != null" when moving fast pointer.
    Deal with the case when n == len(linkedlist) first.
    Generally, there're n steps between fast and slow, and slow is just before the node to be deleted.
     */
    public ListNode removeNthFromEndSol2(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int idx = 0; idx < n; idx ++) {
            fast = fast.next;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /*
    Introduce dummy before head, and put slow pointer here, therefore n == len(Linkedlist) is no longer a special case.
    There're n+1 steps between fast and slow, so in the end, fast should be null instead of the last non-null node!
     */
    public ListNode removeNthFromEndSol3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        for (int idx = 0; idx < n; idx ++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /*
    An alternative version of solution3.
    Move faster for n-1 steps, so that there're n steps between fast and slow.
    When move them together, fast should end at the last non-null node.
     */
    public ListNode removeNthFromEndSol4(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = dummy;
        for (int idx = 0; idx < n - 1; idx ++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
