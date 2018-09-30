package pers.leetcode.contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import pers.leetcode.utils.*;
/**
 * Created by bopang on 8/21/18.
 */
public class Contest98 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ret = new int[2];
        int totalA = 0, totalB = 0;
        int[] AllButOne1 = new int[A.length];
        int[] AllButOne2 = new int[B.length];

        for (int ind = 0; ind < A.length; ind ++)
            totalA += A[ind];
        for (int ind = 0; ind < B.length; ind ++)
            totalB += B[ind];

        for (int ind = 0; ind < A.length; ind ++)
            AllButOne1[ind] = totalA - A[ind];

        for (int ind = 0; ind < B.length; ind ++)
            AllButOne2[ind] = totalB - B[ind];

        int ind1 = 0;
        int ind2 = 0;
        boolean found = false;
        for (ind1 = 0; ind1 < A.length; ind1 ++) {
            for (ind2 = 0; ind2 < B.length; ind2 ++) {
                if(AllButOne2[ind2] + A[ind1] == AllButOne1[ind1] + B[ind2]) {
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        return new int[]{A[ind1], B[ind2]};
    }

    private HashSet<String> extractPattern(String word) {
        int[][] tmpArr = new int[256][20];
        for (int ind = 0; ind < word.length(); ind ++) {
            tmpArr[word.charAt(ind) - 'a'][0]++;
            tmpArr[word.charAt(ind) - 'a'][tmpArr[word.charAt(ind) - 'a'][0]] = ind;
        }
        StringBuilder tmp = new StringBuilder();
        HashSet<String> ret = new HashSet<String>();
        for (int ind = 0; ind < 256; ind ++) {
            tmp.setLength(0);
            for (int ind2 = 0; ind2 < tmpArr[ind][0]; ind2 ++) {
                tmp.append(" ");
                tmp.append(Integer.toString(tmpArr[ind][ind2 + 1]));
            }
            if(tmp.length() > 0)
                ret.add(new String(tmp));
        }
        return ret;
    }

    private boolean matchPattern(String word, String pattern) {
        return extractPattern(word).equals(extractPattern(pattern));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ret = new ArrayList<String>();
        for (String word : words) {
            if (matchPattern(word, pattern))
                ret.add(word);
        }
        return ret;
    }

    private TreeNode constructRecursive(int[] pre, int start1, int end1,
                                        int[] post, int start2, int end2) {
        if(start1 > end1 || start2 > end2)
            return null;

        TreeNode root = new TreeNode(pre[start1]);
        int leftRoot = start1 + 1;
        int tmp = start2;
        while(tmp < post.length && post[tmp] != leftRoot) {
            tmp ++;
        }
        root.left = constructRecursive(pre, leftRoot, tmp + 1, post, start2, tmp);
        root.right = constructRecursive(pre, tmp + 2, end1, post, tmp + 1, end2 - 1);
        return root;
    }

    // Unsolved problem
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructRecursive(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
}
