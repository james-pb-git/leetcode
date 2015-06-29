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
		int maxDepth(TreeNode *root) {
			if( root == NULL )
				return 0;
			int leftDepth = maxDepth( root -> left );
			int rightDepth = maxDepth( root -> right );
			if( leftDepth > rightDepth )
				return leftDepth + 1;
			return rightDepth + 1;
	}
};

int main()
{
    Solution solution;

    TreeNode * test1 = new TreeNode(3);
    TreeNode * test2 = new TreeNode(4);
    test1 -> left = test2;

    cout << solution.maxDepth( test1 ) << endl;

    return 0;
}
