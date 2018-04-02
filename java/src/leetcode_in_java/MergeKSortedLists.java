package leetcode_in_java;

/**
 * Created by bopang on 18/4/2.
 */
public class MergeKSortedLists {
    private ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            }
            else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }
        if(list1 == null)
            curNode.next = list2;
        else if (list2 == null)
            curNode.next = list1;
        return dummy.next;
    }

    private ListNode mergeKListsRecursive(ListNode[] lists, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return lists[start];
        // Notice that this will automatically deal with the case when there are only two lists to merge.
        // i.e. when start + 1 == end.
        ListNode list1 = mergeKListsRecursive(lists, start, (start + end) >> 1);
        ListNode list2 = mergeKListsRecursive(lists, ((start + end) >> 1) + 1, end);
        return mergeTwoSortedLists(list1, list2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0)
            return null;
        return mergeKListsRecursive(lists, 0, lists.length - 1);
    }

    public void testCases() {
        ListNode[] nodes = new ListNode[10];
        for (int idx = 0; idx < 10; idx ++) {
            nodes[idx] = new ListNode(idx);
        }
        ListNode[] lists = new ListNode[]{nodes[0], nodes[1], nodes[3], nodes[5]};
        nodes[0].next = nodes[2];
        nodes[2].next = nodes[9];
        nodes[1].next = nodes[4];
        nodes[3].next = nodes[7];
        nodes[5].next = null;
        ListNode res = mergeKLists(lists);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
