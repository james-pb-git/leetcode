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
		bool hasCycle(ListNode *head) {
			ListNode * fast = head;
			ListNode * slow = head;

			if( fast == NULL || fast -> next == NULL )
				return false;

			while(1)
			{
				if( fast -> next != NULL )
					fast = fast -> next -> next;
				else
					return false;
				slow = slow -> next;

				if( fast == NULL )
					return false;
				if( fast == slow )
					return true;
			}
		}
};

int main()
{
    Solution solution;

    ListNode * node1 = new ListNode(1);
    node1->next = new ListNode(2);
    node1->next->next = node1->next;

    ListNode * node2 = new ListNode(3);

    cout << solution.hasCycle( node1 ) << endl;
    cout << solution.hasCycle( node2 ) << endl;

    return 0;
}
