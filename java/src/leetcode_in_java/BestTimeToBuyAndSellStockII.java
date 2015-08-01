package leetcode_in_java;

/**
 * Created by bopang on 15/8/1.
 */
class BestTimeToBuyAndSellStockII {
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
}
