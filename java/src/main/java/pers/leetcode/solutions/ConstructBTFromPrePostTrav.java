package pers.leetcode.solutions;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 8/22/18.
 */
public class ConstructBTFromPrePostTrav {
    private TreeNode constructRecursiveImproved(int[] pre, int preStart, int preEnd,
                                                int[] post, int postStart, int postEnd) {
        if (preStart > preEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd)
            return root;

        int subPreStart, subPreEnd, subPostStart, subPostEnd;
        subPreStart = preStart + 1;

        subPostStart = postStart;
        subPostEnd = postStart;
        while (post[subPostEnd] != pre[subPreStart])
            subPostEnd ++;

        subPreEnd = subPreStart + subPostEnd - subPostStart;
        root.left = constructRecursiveImproved(pre, subPreStart, subPreEnd, post, subPostStart, subPostEnd);
        root.right = constructRecursiveImproved(pre, subPreEnd + 1, preEnd, post, subPostEnd + 1, postEnd - 1);

        return root;
    }

    private TreeNode constructRecursive(int[] pre, int preStart, int preEnd,
                                        int[] post, int postStart, int postEnd) {
        if (preStart > preEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);

        int subPreStart, subPreEnd, subPostStart, subPostEnd;

        subPreStart = preStart + 1;
        if (subPreStart > preEnd)
            return root;

        subPostStart = postStart;
        subPostEnd = postStart;
        while (post[subPostEnd] != pre[subPreStart])
            subPostEnd ++;

        subPreEnd = subPreStart;

        // This is stupid!
        for (int step = 0; step < subPostEnd - subPostStart; step ++)
            subPreEnd ++;
        root.left = constructRecursive(pre, subPreStart, subPreEnd, post, subPostStart, subPostEnd);

        subPreStart = subPreEnd + 1;
        if (subPreStart > preEnd) {
            root.right = null;
            return root;
        }
        subPreEnd = preEnd;

        subPostStart = subPostEnd + 1;
        subPostEnd = postEnd - 1;
        root.right = constructRecursive(pre, subPreStart, subPreEnd, post, subPostStart, subPostEnd);
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructRecursive(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
}
