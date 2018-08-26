package leetcode_in_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by bopang on 8/26/18.
 */
public class Contest99 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if (N == 0)
            return ret;

        if (N == 1) {
            ret.add(new TreeNode(0));
            return ret;
        }

        int numNodesLeft;
        List<TreeNode> leftArr, rightArr;
        for (numNodesLeft = 1; numNodesLeft < N - 1; numNodesLeft ++) {
            leftArr = allPossibleFBT(numNodesLeft);
            rightArr = allPossibleFBT(N - 1 - numNodesLeft);
            for (int ind1 = 0; ind1 < leftArr.size(); ind1 ++) {
                for (int ind2 = 0; ind2 < rightArr.size(); ind2 ++) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftArr.get(ind1);
                    root.right = rightArr.get(ind2);
                    ret.add(root);
                }
            }
        }
        return ret;
    }

    private String extractFeature(String str) {
        ArrayList<Character> odd = new ArrayList<Character>();
        ArrayList<Character> even = new ArrayList<Character>();
        for (int ind = 0; ind < str.length(); ind ++) {
            if ((ind & 1) == 1)
                odd.add(str.charAt(ind));
            else
                even.add(str.charAt(ind));
        }

        Collections.sort(odd);
        Collections.sort(even);

        StringBuilder sb = new StringBuilder();
        for(Character ch : odd) {
            sb.append(ch);
        }
        sb.append(" ");
        for(Character ch : even)
            sb.append(ch);
        return sb.toString();
    }

    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> featureSet = new HashSet<String>();
        for (String ele: A)
            featureSet.add(extractFeature(ele));
        return featureSet.size();
    }

    public int surfaceArea(int[][] grid) {
        int len = grid.length;
        int countEle = 0;
        int surface = 0;

        for (int iRow = 0; iRow < len; iRow ++) {
            for (int iCol = 0; iCol < len; iCol ++) {
                if (grid[iRow][iCol] != 0)
                    countEle ++;
                if (iRow == 0)
                    surface += grid[iRow][iCol];
                if (iRow == len - 1)
                    surface += grid[iRow][iCol];
                if (iRow > 0 && grid[iRow][iCol] > grid[iRow-1][iCol])
                    surface += grid[iRow][iCol] - grid[iRow-1][iCol];
                if (iRow < len - 1 && grid[iRow][iCol] > grid[iRow+1][iCol])
                    surface += grid[iRow][iCol] - grid[iRow+1][iCol];

                if (iCol == 0)
                    surface += grid[iRow][iCol];
                if (iCol == len - 1)
                    surface += grid[iRow][iCol];
                if (iCol > 0 && grid[iRow][iCol] > grid[iRow][iCol-1])
                    surface += grid[iRow][iCol] - grid[iRow][iCol-1];
                if (iCol < len - 1 && grid[iRow][iCol] > grid[iRow][iCol+1])
                    surface += grid[iRow][iCol] - grid[iRow][iCol+1];
            }
        }

        return surface + countEle * 2;
    }

}
