package leetcode_in_java;
import java.util.*;
/**
 * Created by bopang on 15/7/28.
 */

public class Solution {

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

    public static void main( String args[] ) {
        System.out.println("Hello Leetcode");
        Solution solution = new Solution();
    }
}