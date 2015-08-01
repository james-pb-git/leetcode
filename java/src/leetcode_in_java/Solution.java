package leetcode_in_java;

/**
 * Created by bopang on 15/7/28.
 */

public class Solution {
    public int maxProfit(int[] prices) {
        if( null == prices || prices.length == 0)
            return 0;
        int profit = 0;
        for( int idx = 1; idx < prices.length ; idx ++ ) {
            if( prices[ idx ] > prices[ idx - 1 ] )
                profit += prices[ idx ] - prices[ idx - 1 ];
        }
        return profit;
    }
    public static void main( String args[] ) {
        System.out.println( "Hello Leetcode");
    }
}