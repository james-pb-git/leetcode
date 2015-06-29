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

class Solution {
    public:

	    /*
	    void reverse_string( char String[] )
	    {
		    char buf = 0;
		    int stringLength = strlen( String );
		    for( int index = 0; index < stringLength / 2; index ++ )
		    {
			    buf = String[index];
			    String[index] = String[stringLength - index - 1];
			    String[stringLength - index - 1] = buf;
		    }
		    return;
	    }

	    */

	    void intToReversedStr( int abs_x, char String[], int base )
	    {
		    // Remove the useless "0"
		    while( ( abs_x != 0 ) && (abs_x % base == 0) )
			    abs_x /= base;

		    if( abs_x == 0 )
		    {
			    String[0] = '0';
			    String[1] = '\0';
			    return;
		    }

		    int index = 0;
		    while( abs_x != 0 )
		    {
			    String[index] = '0' + ( abs_x % base );
			    index ++;
			    abs_x /= base;
		    }
		    String[index] = '\0';
	    }

	    int reverse( int x )
	    {
		    int abs_x = x;
		    if( abs_x < 0 )
			    abs_x = -x;

		    char String[50] = "0";
		    intToReversedStr( abs_x, String, 10 );
	//	    reverse_string( String );
		    int reverse_abs = atoi( String );
		    int res = reverse_abs;
		    if( x < 0 )
			    res = - res;
		    return res;
	    }
};
int main()
{
    Solution solution;

    int test1 = 123;
    int test2 = -345;
    int test3 = 100;
    int test4 = -6093;
    int test5 = 1000000003;

    cout << solution.reverse( test1 ) << endl;
    cout << solution.reverse( test2 ) << endl;
    cout << solution.reverse( test3 ) << endl;
    cout << solution.reverse( test4 ) << endl;
    cout << solution.reverse( test5 ) << endl;

    return 0;
}
