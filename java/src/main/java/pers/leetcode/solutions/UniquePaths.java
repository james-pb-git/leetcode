package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/20.
 */
public class UniquePaths {
    private int comb( int n, int m ) {
        if( n < 0 || m < 0 || m > n )
            return 0;

        int[][] bufferedAns = new int[n+1][n+1];

        bufferedAns[0][0] = 1;
        for( int idx = 1; idx < n+1; idx ++ )
            bufferedAns[ 0 ][ idx ] = 0;

        for( int idx = 1; idx < n+1; idx ++ )
            bufferedAns[ idx ][ 0 ] = 1;

        for( int idx1 = 1; idx1 < n + 1; idx1 ++ ) {
            for( int idx2 = 1; idx2 < n + 1; idx2 ++ ) {
                bufferedAns[ idx1 ][ idx2 ] = bufferedAns[ idx1 - 1 ][ idx2 - 1]
                        + bufferedAns[ idx1 - 1 ][ idx2 ];
            }
        }
        return bufferedAns[ n ][ m ];
    }

    public int uniquePaths(int m, int n) {
        return comb( m + n - 2, m - 1 );
    }
}
