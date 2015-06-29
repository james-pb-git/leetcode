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
		int numTrees(int n)
		{
			if( n < 0 )
				return 0;

			vector<int> resBuffer;
			resBuffer.push_back(1);
			int target = 1;
			for( ; target <= n; target ++ )
			{
				int cur_res = 0;
				for( int index = 0; index < target; index ++ )
				{
					cur_res += resBuffer[index] * resBuffer[target-1-index];
				}
				resBuffer.push_back( cur_res );
			}
			return resBuffer[n];
		}
};

int main()
{
    Solution solution;
    for( int i = 0; i <= 15; i ++ )
    {
	    cout << solution.numTrees( i ) << endl;
    }

    return 0;
}	
