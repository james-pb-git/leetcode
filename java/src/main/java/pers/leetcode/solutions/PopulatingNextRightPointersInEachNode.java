package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 15/8/7.
 */
class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if( null == root || null == root.left )
            return;
        TreeLinkNode prevHead = root;
        TreeLinkNode curHead = root.left;
        while( null != curHead ) {
            TreeLinkNode prevIter = prevHead;
            TreeLinkNode curIter = curHead;

            curIter.next = prevIter.right;
            curIter = curIter.next;
            while( null != prevIter.next ) {
                prevIter = prevIter.next;

                curIter.next = prevIter.left;
                curIter = curIter.next;

                curIter.next = prevIter.right;
                curIter = curIter.next;
            }

            prevHead = curHead;
            curHead = curHead.left;
        }
    }
}
