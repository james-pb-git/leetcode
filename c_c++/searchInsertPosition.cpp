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
		int searchInsert(int A[], int n, int target) {
			int left = 0, right = n;
			while( left != right )
			{
				int mid = left + ( right - left ) / 2 ;
				if( A[mid] > target )
					right = mid;
				else if( A[mid] < target )
					left = mid + 1;
				else
					return mid;
			}
			return left;
		}
};

int main()
{
    Solution solution;

    int A1[] = { 1,3,4,5 };
    int n1 = 4;
    int target1 = 2;

    int A2[] = { 1,2,3,4 };
    int n2 = 4;
    int target2 = 0;

    int A3[] = { 2,3,4,5};
    int n3 = 4;
    int target3 = 6;

    cout << solution.searchInsert( A1, n1, target1 ) << endl;
    cout << solution.searchInsert( A2, n2, target2 ) << endl;
    cout << solution.searchInsert( A3, n3, target3 ) << endl;


    return 0;
}	
