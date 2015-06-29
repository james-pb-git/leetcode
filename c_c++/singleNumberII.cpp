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

// Definition for singly-linked list.
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
	public:
		int singleNumber(int A[], int n) {

			unsigned bitWidth = sizeof( int ) * 8;
			
			unsigned bitCounter = 0;

			int res = 0;
			for( int bitBias = 0; bitBias < bitWidth; bitBias ++ )
			{
				bitCounter = 0;
				unsigned mask = (1 << bitBias);
				for( int index = 0; index < n; index ++ )
				{
					bitCounter += ( ( unsigned(A[index]) & mask ) >> bitBias );
				}
//				cout << bitBias << " : " << bitCounter << endl;
				if( bitCounter % 3 == 1 )
					res |= ( 1 << bitBias );
			}
			return res;
		}
};
int main()
{
    Solution solution;

    int test1[] = { 1,1,2,2,3,2,1};
    int test2[] = { 2,3,3,2,3,2,1};
    int test3[] = { -1 };
    int test4[] = { -1, -2, -3, -3, -2, -3, -2};

    cout << solution.singleNumber( test1,7) << endl;
    cout << solution.singleNumber( test2,7) << endl;
    cout << solution.singleNumber( test3,1) << endl;
    cout << solution.singleNumber( test4,7) << endl;

    return 0;
}
