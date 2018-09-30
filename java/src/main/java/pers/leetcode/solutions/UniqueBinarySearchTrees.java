package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/8.
 */
class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if( n < 0 )
            return 0;

        int[] bufferedAns = new int[ n+1 ];
        bufferedAns[0] = 1;

        for( int sizeTree = 1; sizeTree <= n; sizeTree ++ ) {
            int tmpAns = 0;
            for( int rootIdx = 1; rootIdx <= sizeTree; rootIdx ++ ) {
                tmpAns += bufferedAns[ rootIdx - 1] * bufferedAns[ sizeTree - rootIdx ];
            }
            bufferedAns[ sizeTree ] = tmpAns;
        }
        return bufferedAns[ n ];
    }
}
