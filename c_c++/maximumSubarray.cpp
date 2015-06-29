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

		// Dynamic programming
		int maxSubArray_dp_solution( int A[], int n ) {
			
			if( n == 0 )
				return 0;

			int maxSoFar = A[0] - 1;
			int maxEndingHere = 0;

			for( int index = 0; index < n; index ++ )
			{
				/*
				if( maxEndingHere + A[index] < 0 )
					maxEndingHere = 0;
				else
					maxEndingHere += A[index];
				*/

				if( maxEndingHere > 0 )
					maxEndingHere += A[index];
				else
					maxEndingHere = A[index];

				if( maxEndingHere > maxSoFar )
					maxSoFar = maxEndingHere;
			}
			return maxSoFar;
		}

		// Divide and conquer
		int maxSubArray_dc_solution( int A[], int n ) {
			//
		}

		int maxSubArray(int A[], int n) {
			return maxSubArray_dp_solution( A, n );
		}
};

int main()
{
    Solution solution;
    int test1[] = { 1,-1,3,4};
    int test2[] = {-2,1,-3,4,-1,2,1,-5,4};
    int test3[] = {-1};

    cout << solution.maxSubArray( test1, sizeof( test1 ) / sizeof( int ) ) << endl;
    cout << solution.maxSubArray( test2, sizeof( test2 ) / sizeof( int ) ) << endl;
    cout << solution.maxSubArray( test3, sizeof( test3 ) / sizeof( int ) ) << endl;

    return 0;
}	
