package leetcode_in_java;

/**
 * Created by bopang on 15/8/13.
 */
class ClimbingStairs {
    public int climbStairs(int n) {
        if( n <= 0 )
            return 0;
        int[] bufferedAns = new int[ n+1 ];
        bufferedAns[0] = 0;
        bufferedAns[1] = 1;
        for( int idx = 2; idx < n+1; idx ++ ) {
            if( idx == 2 )
                bufferedAns[ idx ] = 2;
            else
                bufferedAns[ idx ] = bufferedAns[ idx - 1 ] + bufferedAns[ idx - 2 ];
        }
        return bufferedAns[ n ];
    }
}
