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
		ListNode* detectCycle(ListNode *head) {
			ListNode * fast = head;
			ListNode * slow = head;

			unsigned countFastStep = 0;
			unsigned countSlowStep = 0;

			if( fast == NULL || fast -> next == NULL )
				return NULL;

			while(1)
			{
				if( fast -> next != NULL )
				{
					fast = fast -> next -> next;
					countFastStep += 2;
				}
				else
					return NULL;
				slow = slow -> next;
				countSlowStep ++;

				if( fast == NULL )
					return NULL;
				if( fast == slow )
					break;
			}
			unsigned lengthCycle = countFastStep - countSlowStep;
			fast = head;
			slow = head;
			for( int step = 0; step < lengthCycle; step ++ )
				fast = fast -> next;
			while( fast != slow )
			{
				fast = fast -> next;
				slow = slow -> next;
			}
			return slow;
		}
};

int main()
{
    Solution solution;

    ListNode * node1 = new ListNode(1);
    node1->next = new ListNode(2);
    node1->next->next = node1->next;

    ListNode * node2 = new ListNode(3);

    cout << solution.detectCycle( node1 ) -> val << endl;
    cout << solution.detectCycle( node2 ) << endl;

    return 0;
}
