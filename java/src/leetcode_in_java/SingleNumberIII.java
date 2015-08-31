package leetcode_in_java;

/**
 * Created by bopang on 15/8/18.
 */
class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        if( null ==  nums || nums.length == 0 )
            return null;
        int[] ans = new int[2];

        int xorValue = 0;
        for( int ele: nums ) {
            xorValue ^= ele;
        }
        int bitIdx = 0;
        for( ; bitIdx < 32; bitIdx ++ ) {
            if( ( xorValue & ( 1 << bitIdx ) ) != 0  )
                break;
        }

        int tmpAns = 0;
        for( int ansIdx = 0; ansIdx < 2; ansIdx ++ ) {
            tmpAns = 0;
            for( int ele: nums ) {
                if( ( ( ele >> bitIdx ) & 1) == ansIdx ) {
                    tmpAns ^= ele;
                }
            }
            ans[ ansIdx ] = tmpAns;
        }
        return ans;
    }
}
