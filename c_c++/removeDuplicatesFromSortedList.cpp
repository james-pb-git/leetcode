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
    		ListNode *deleteDuplicates(ListNode *head) {

			ListNode* curNode = head;
			ListNode * preNode = NULL;
			bool first = true;

			while( curNode != NULL )
			{
				if( first )
				{
					preNode = curNode;
					curNode = curNode -> next;
					first = false;
				}
				else
				{
					if( ( curNode -> val ) == ( preNode -> val ) )
					{
						preNode -> next = curNode -> next;
						curNode = curNode -> next;
					}
					else
					{
						preNode = curNode;
						curNode = curNode -> next;
					}
				}
			}
			return head;
		}
};

int main()
{
    Solution solution;

    ListNode* test1 = new ListNode(1);
    test1 -> next = new ListNode(2);
    test1 -> next -> next = new ListNode(2);

    ListNode* test2 = new ListNode(3);
    test2 -> next = new ListNode(5);

    ListNode* test3 = new ListNode(2);
    test3 -> next = new ListNode(2);
    test3 -> next -> next = new ListNode(3);

    solution.deleteDuplicates( test1 );
    solution.deleteDuplicates( test2 );
    solution.deleteDuplicates( test3 );

    ListNode* p = test3;
    while( p != NULL )
    {
	    cout << p -> val << " " ;
	    p = p -> next;
    }
    cout << endl;

    return 0;
}	
