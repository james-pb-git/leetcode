package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 18/8/4.
 */
public class AllNodesDistanceKinBinaryTree {
    private int searchThroughPathToTarget(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null)
            return -1;

        if (root == target) {
            findKDistanceDownwards(root, K, 0, res);
            return 0;
        }

        int disLeft = searchThroughPathToTarget(root.left, target, K, res);
        if (disLeft >= 0) {
            if (K - disLeft == 1) {
                res.add(root.val);
            }
            else
                findKDistanceDownwards(root.right, K - disLeft - 2, 0, res);
            return disLeft + 1;
        }

        int disRight = searchThroughPathToTarget(root.right, target, K, res);
        if (disRight >= 0) {
            if (K - disRight == 1) {
                res.add(root.val);
            }
            else
                findKDistanceDownwards(root.left, K - disRight - 2, 0, res);
            return disRight + 1;
        }
        return -1;
    }

    private void findKDistanceDownwards(TreeNode start, int K, int curDis, List<Integer> res) {
        if (start == null || K < 0)
            return;

        if (curDis == K) {
            res.add(start.val);
            return;
        }
        findKDistanceDownwards(start.left, K, curDis + 1, res);
        findKDistanceDownwards(start.right, K, curDis + 1, res);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        searchThroughPathToTarget(root, target, K, res);
        return res;
    }
}
