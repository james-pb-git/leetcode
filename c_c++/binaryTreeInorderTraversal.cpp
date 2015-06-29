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

// Definition for binary tree
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution {
	public:

		void recursivePreorderTraversal( TreeNode *root, vector<int> & result )
		{
			if( root == NULL )
				return;

			result.push_back( root -> val );
			recursivePreorderTraversal( root -> left, result );
			recursivePreorderTraversal( root -> right, result );

			return;
		}

		vector<int> preorderTraversal(TreeNode *root) {

			vector<int> res;
			recursivePreorderTraversal( root, res );
			return res;
		}
};

int main()
{
    Solution solution;

    TreeNode * test1 = new TreeNode( 1 );
    test1 -> right = new TreeNode( 2 );
    test1 -> right -> left = new TreeNode( 3 );

    vector<int> testRes= solution.preorderTraversal( test1 );

    for( int index = 0; index < testRes.size(); index ++ )
	    cout << testRes[index] << endl;


    return 0;
}	
