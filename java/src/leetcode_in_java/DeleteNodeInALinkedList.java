/**
 * Created by bopang on 15/7/29.
 */

package leetcode_in_java;

class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {

        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

}
