package leetcode_in_java;

/**
 * Created by bopang on 15/8/13.
 */
class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if( null == head )
            return null;

        ListNode preNode = head;
        int preValue = head.val;
        ListNode curNode = head.next;
        int curValue = 0;
        while( null != curNode ) {
            curValue = curNode.val;

            if( curValue == preValue ) {
                preNode.next = curNode.next;
            }
            else {
                preNode = curNode;
                preValue = curValue;
            }
            curNode = curNode.next;
        }
        return head;
    }
}
