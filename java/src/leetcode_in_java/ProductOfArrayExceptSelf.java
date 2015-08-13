package leetcode_in_java;

/**
 * Created by bopang on 15/8/12.
 */
class ProductOfArrayExceptSelf {

    // Time: O( n^2 ), Space: O( n )
    public int[] productExceptSelfTrivialSolution(int[] nums) {
        if( null == nums || 0 == nums.length )
            return null;
        int[] ans = new int[ nums.length ];
        for( int idx = 0; idx < nums.length; idx ++ )
            ans[ idx ] = 1;

        for( int idxIn = 0; idxIn < nums.length; idxIn ++ ) {
            for( int idxOut = 0; idxOut < nums.length; idxOut ++ ) {
                if( idxIn != idxOut ) {
                    ans[ idxOut ] *= nums[ idxIn ];
                }
            }
        }
        return ans;
    }

    // Time: O( n ), Space: O( n )
    public int[] productExceptSelf(int[] nums) {
        if( null == nums || 0 == nums.length )
            return null;
        int[] ans = new int[ nums.length ];
        int tmpProduct = 1;
        for( int idx = 0; idx < nums.length; idx ++ )
        {
            ans[ idx ] = tmpProduct;
            tmpProduct *= nums[ idx ];
        }

        tmpProduct = 1;
        for( int idx = nums.length -1; idx >= 0; idx -- ) {
            ans[ idx ] *= tmpProduct;
            tmpProduct *= nums[ idx ];
        }
        return ans;
    }
}
