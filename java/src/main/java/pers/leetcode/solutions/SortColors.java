package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/25.
 */
class SortColors {
    private void swap( int[] nums, int idx1, int idx2 ) {
        int tmpVal = 0;
        tmpVal = nums[ idx1 ];
        nums[ idx1 ] = nums[ idx2 ];
        nums[ idx2 ] = tmpVal;
    }

    public void sortColors(int[] nums) {

        // [ 0, idx1 ] : 0
        // ( idx1, idx2 ] : 1
        // ( idx2, idx3 ] : 2
        // ( idx3, nums.length - 1 ] : unknown

        if( null == nums || nums.length == 0 )
            return;

        int idx1 = -1;
        int idx2 = -1;
        int idx3 = -1;

        for( int idx = 0; idx < nums.length; idx ++ ) {
            if( nums[ idx ] == 0 ) {
                idx3 ++;
                idx2 ++;
                idx1 ++;
                swap( nums, idx2, idx3 );
                swap( nums, idx2, idx1 );
            }
            else if( nums[ idx ] == 1 ) {
                idx3++;
                idx2++;
                swap( nums, idx2, idx3 );
            }
            else {
                idx3 ++;
            }
        }
    }
}
