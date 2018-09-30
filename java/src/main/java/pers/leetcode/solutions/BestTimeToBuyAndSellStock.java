package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/22.
 */
class BestTimeToBuyAndSellStock {
    public int maxProfitSolutionI(int[] prices) {
        if( null == prices || prices.length == 0 )
            return 0;
        int[] tmpArr = new int[ prices.length ];
        int minPrice = prices[0];
        tmpArr[0] = minPrice;
        for( int idx = 1; idx < tmpArr.length; idx ++ ) {
            if( prices[ idx ] < minPrice ) {
                minPrice = prices[ idx ];
            }
            tmpArr[ idx ] = minPrice;
        }

        int maxPrice = prices[ prices.length - 1 ];
        int ans = maxPrice - tmpArr[ prices.length - 1 ];
        for( int idx = tmpArr.length - 2; idx >= 0 ; idx -- ) {
            if( prices[ idx ] > maxPrice ) {
                maxPrice = prices[ idx ];
            }
            if( maxPrice - tmpArr[ idx ] > ans )
                ans = maxPrice - tmpArr[ idx ];
        }
        return ans;
    }

    public int maxProfitSolutionII(int[] prices) {
        if( null == prices || prices.length == 0 )
            return 0;
        int minSoFar = prices[0] + 1;
        int maxProfitSoFar = -1;
        for( int idx = 0; idx < prices.length; idx ++ ) {
            if( prices[ idx ] < minSoFar )
                minSoFar = prices[ idx ];
            if( prices[ idx ] - minSoFar > maxProfitSoFar )
                maxProfitSoFar = prices[ idx ] - minSoFar;
        }
        return maxProfitSoFar;
    }
}
