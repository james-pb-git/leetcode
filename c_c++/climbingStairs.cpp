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
		int climbStairs(int n) {
			if( n <= 0 )
				return 0;
			if( n == 1 )
				return 1;
			if( n == 2 )
				return 2;

			int preRes = 1;
			int curRes = 2;

			for( int index = 3; index <= n; index ++ )
			{
				int tmp = curRes;
				curRes = curRes + preRes;
				preRes = tmp;
			}
			return curRes;
		}

};

int main()
{
    Solution solution;

    for( int index = 0; index <= 20; index ++ )
    {
	    cout << index << " : " << solution.climbStairs( index ) << endl;
    }

    return 0;
}	
