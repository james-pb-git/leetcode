/**
 * Created by bopang on 15/7/28.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public void deleteNode(ListNode node) {

        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}