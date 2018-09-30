package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/11.
 */
class SingleNumberII {
    private boolean getBitByIdx( int num, int idx ) {
        int mask = (1 << idx);
        return ( (num & mask) != 0 );
    }
    public int singleNumber(int[] nums) {
        if( null == nums && 0 == nums.length )
            return 0;

        int[] bitCount = new int[32];
        for( int tmpIdx = 0; tmpIdx < 32; tmpIdx ++ )
            bitCount[ tmpIdx ] = 0;

        for( int eleIdx = 0; eleIdx < nums.length; eleIdx ++ ) {
            for( int bitIdx = 0; bitIdx < 32; bitIdx ++ ) {
                if( getBitByIdx( nums[ eleIdx ], bitIdx ) ) {
                    bitCount[ bitIdx ] += 1;
                    if( bitCount[ bitIdx ] == 3 )
                        bitCount[ bitIdx ] = 0;
                }
            }
        }

        int base = 1;
        int ans = 0;
        for( int bitIdx = 0; bitIdx < 32; bitIdx ++ ) {
            if( bitCount[ bitIdx ] != 0 ) {
                ans += base;
            }
            base *= 2;
        }
        return ans;
    }
}
