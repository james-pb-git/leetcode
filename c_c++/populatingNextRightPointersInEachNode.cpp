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

// Definition for binary tree with next pointer.
struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
	public:
		void WrongAnswer_connect(TreeLinkNode *root) {
			if( NULL == root )
				return;

			if( NULL != root -> left )
			{
				root -> left -> next = root -> right;

				if( NULL != root -> left -> right )
					root -> left -> right -> next = root -> right -> left;

				connect( root -> left );
				connect( root -> right );
			}
			return;
		}
		void connect(TreeLinkNode *root) {
			TreeLinkNode * preLevelStart = NULL;
			TreeLinkNode * curLevelStart = root;

			while( NULL != curLevelStart )
			{
				TreeLinkNode * preLevelIterator = preLevelStart;
				TreeLinkNode * curLevelIterator = curLevelStart;
				while( NULL != preLevelIterator )
				{
					curLevelIterator -> next = preLevelIterator -> right;
					
					curLevelIterator = curLevelIterator -> next;
					preLevelIterator = preLevelIterator -> next;

					if( NULL != preLevelIterator )
					{
						curLevelIterator -> next = preLevelIterator -> left;
						curLevelIterator = curLevelIterator -> next;
					}
				}

				preLevelStart = curLevelStart;
				curLevelStart = curLevelStart -> left;
			}
			return;
		}
};

void testPrintTree( TreeLinkNode* p, unsigned step )
{
	if( p != NULL )
	{
		cout << "Current Node Index: " << step << endl;
	        cout << "Current Node Value: " << p -> val << endl;
		cout << "Next Node Value: " << ( ( p -> next == NULL ) ? -1 : ( p -> next -> val ) ) << endl;
		cout << "-----------------------------------------" << endl;
		step ++;
		testPrintTree( p -> left, step );
		step ++;
		testPrintTree( p -> right, step );
	}
	return;
}

int main()
{
    Solution solution;

    TreeLinkNode * test1 = new TreeLinkNode( 1 );
    test1 -> left = new TreeLinkNode( 2 ) ;
    test1 -> right = new TreeLinkNode( 3 );
    test1 -> left -> left = new TreeLinkNode( 4 );
    test1 -> left -> right = new TreeLinkNode( 5 );
    test1 -> right -> left = new TreeLinkNode( 6 );
    test1 -> right -> right = new TreeLinkNode( 7 );

    test1 -> left -> left -> left = new TreeLinkNode( 8 );
    test1 -> left -> left -> right = new TreeLinkNode( 9 );
    test1 -> left -> right -> left = new TreeLinkNode( 10 );
    test1 -> left -> right -> right = new TreeLinkNode( 11 );
    test1 -> right -> left -> left = new TreeLinkNode( 12 );
    test1 -> right -> left -> right = new TreeLinkNode( 13 );
    test1 -> right -> right -> left = new TreeLinkNode( 14 );
    test1 -> right -> right -> right = new TreeLinkNode( 15 );

    solution.connect( test1 );
    TreeLinkNode* p = test1;
    testPrintTree( p, 0 );

    return 0;
}	
