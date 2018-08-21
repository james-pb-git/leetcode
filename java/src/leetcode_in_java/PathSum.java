package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 8/21/18.
 */
public class PathSum {

    /************************* Problem: Path Sum *****************************/

    private boolean hasPathSumRecursive(TreeNode root, int curSum, int sum) {
        curSum += root.val;
        if (root.left == null && root.right == null)
            return curSum == sum;
        if (root.left != null && hasPathSumRecursive(root.left, curSum, sum))
            return true;
        if (root.right != null && hasPathSumRecursive(root.right, curSum, sum))
            return true;
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return hasPathSumRecursive(root, 0, sum);
    }

    /* Improvements
    1) Instead of maintaining a curSum variable, we just use sum - root.val as the parameter.
       Notice that, since the parameter value won't be changed after call the function, there's no need
       to implement backtracking; thus, the logic can be improved further.
    2) Whenever root == null, just return false, thus we don't need to consider this before function call.
     */
    public boolean hasPathSumImproved(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null)
            return sum == root.val;
        return (hasPathSumImproved(root.left, sum - root.val) ||
                hasPathSumImproved(root.right, sum - root.val));
    }

    /************************* Problem: Path Sum II *****************************/
    /* Important note: every time a new solution found, remember to add a copy of curPath to ret,
       instead of curPath itself, because all elements in it will be removed later.
     */
    private void pathSumRecursive(TreeNode root, int sum,
                                      List<Integer> curPath, List<List<Integer>> ret) {
        if (root == null) return;
        curPath.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ret.add(new ArrayList<Integer>(curPath));
            curPath.remove(curPath.size() - 1);
            return;
        }
        pathSumRecursive(root.left, sum - root.val, curPath, ret);
        pathSumRecursive(root.right, sum - root.val, curPath, ret);
        curPath.remove(curPath.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> curPath = new ArrayList<Integer>();
        pathSumRecursive(root, sum, curPath, ret);
        return ret;
    }
}
