package leetcode_in_java;

/**
 * Created by bopang on 15/8/28.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if( null == grid || 0 == grid.length )
            return 0;
        int height = grid.length;
        int width = grid[ 0 ].length;
        int[][] bufferedAns = new int[ height ][ width ];
        int tmpSum = 0;
        for( int idx = 0; idx < height; idx ++ ) {
            tmpSum += grid[ idx ][ 0 ];
            bufferedAns[ idx ][ 0 ] = tmpSum;
        }
        tmpSum = 0;
        for( int idx = 0; idx < width; idx ++ ) {
            tmpSum += grid[ 0 ][ idx ];
            bufferedAns[ 0 ][ idx ] = tmpSum;
        }

        for( int idx1 = 1; idx1 < height; idx1 ++ ) {
            for( int idx2 = 1; idx2 < width; idx2 ++ ) {
                bufferedAns[ idx1 ][ idx2 ] =
                        ( bufferedAns[ idx1-1 ][ idx2 ] < bufferedAns[ idx1 ][ idx2 - 1 ] ) ?
                                ( bufferedAns[ idx1 - 1 ][ idx2 ] + grid[ idx1 ][ idx2 ] ) :
                                ( bufferedAns[ idx1 ][ idx2 - 1] + grid[ idx1 ][ idx2 ] );
            }
        }
        return bufferedAns[ height - 1 ][ width - 1 ];
    }
}
