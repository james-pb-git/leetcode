/***************************************************************************
 * 
 * Copyright (c) 2013 Baidu.com, Inc. All Rights Reserved
 * 
 **************************************************************************/
 
 
 
/**
 * @file test.cpp
 * @author pangbo02(com@baidu.com)
 * @date 2013/11/27 21:34:30
 * @brief 
 *  
 **/

#include<stdio.h>
#include<string.h>
#include<iostream>
#include<vector>
#include<string>
#include<cmath>
using namespace std;

class Solution {
	public:
		int maxProfit(vector<int> &prices)
		{
			unsigned N = prices.size();

			int res = 0;

			int curPrice = 0;
			int prePrice = 0;

			for( unsigned index = 0; index < N; index ++ )
			{
				curPrice = prices[index];
				if( index == 0 )
					prePrice = curPrice;
				else
					prePrice = prices[index-1];

				if( curPrice > prePrice )
					res += curPrice - prePrice;
			}

			return res;
		}
};

int main()
{
    Solution solution;

    int tmp_arr1[] = {1,2,3,4,5};
    int tmp_arr2[] = {3};
    int tmp_arr3[] = {2,3,5,1,2,1,4,3,6,5};

    vector<int> test1( tmp_arr1, tmp_arr1 + 5);
    vector<int> test2( tmp_arr2, tmp_arr2 + 1);
    vector<int> test3( tmp_arr3, tmp_arr3 + 10);

    cout << solution.maxProfit( test1 ) << endl;
    cout << solution.maxProfit( test2 ) << endl;
    cout << solution.maxProfit( test3 ) << endl;

    return 0;
}	
