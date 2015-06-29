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

#include<cstdio>
#include<string.h>
#include<stdlib.h>
#include<iostream>
#include<vector>
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
	    bool isSameTree(TreeNode *p, TreeNode *q) {
		    if( p == NULL && q == NULL )
			    return true;
		    else if( p != NULL && q != NULL )
		    {
//			    cout << "val1: " << p-> val << endl;
//			    cout << "val2: " << q-> val << endl;
			    return ( ( p->val == q->val ) && ( isSameTree( p -> left, q -> left ) ) && ( isSameTree( p -> right , q -> right ) ) );
		    }
		    else
			    return false;
	    }
};
int main()
{
    Solution solution;

    TreeNode* test_tree1 = new TreeNode(1);
    TreeNode* test_tree2 = new TreeNode(1);
    TreeNode* test_tree3 = new TreeNode(2);

    test_tree1 -> left = new TreeNode(2);
    test_tree2 -> left = new TreeNode(2);
    test_tree1 -> right = new TreeNode(4);
    test_tree2 -> right = new TreeNode(5);


    cout << solution.isSameTree( test_tree1, test_tree1 ) << endl;
    cout << solution.isSameTree( test_tree1, test_tree2 ) << endl;
    cout << solution.isSameTree( test_tree1, test_tree3 ) << endl;
    cout << solution.isSameTree( test_tree2, test_tree3 ) << endl;

    delete test_tree1;
    delete test_tree2;
    delete test_tree3;

    return 0;
}
