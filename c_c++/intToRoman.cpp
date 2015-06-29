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

int romanInt[] = {1,5,10,50,100,500,1000};
char romanStr[] = "IVXLCDM";

class Solution {
    public:


	    string intToRoman(int num)
	    {
		    if( num <= 0 || num >3999 )
			    return "O"; // whatever...

		    char * res = new char[50];
		    char * pRes = res;

		    int tmp_num = num;
		    int cur_count_digit = 0;
		    while( tmp_num != 0 )
		    {
			    tmp_num /= 10;
			    cur_count_digit ++;
		    }
		    // Start processing
		    while( num != 0 )
		    {
			    int romanIndex = ( cur_count_digit - 1 ) * 2;
			    int cur_digit = num / int( pow( 10.0, cur_count_digit - 1 ));
			    if( cur_digit >= 1 && cur_digit <= 3)
			    {
				    for( int tmp_index = 0; tmp_index < cur_digit; tmp_index ++ )
				    {
					   *pRes ++ = romanStr[romanIndex];
				    }
			    }
			    else if( cur_digit == 4 )
			    {
				    * pRes ++ = romanStr[romanIndex];
				    * pRes ++ = romanStr[romanIndex+1];
			    }
			    else if( cur_digit == 5 )
			    {
				    * pRes ++ = romanStr[romanIndex+1];
			    }
			    else if( cur_digit >= 6 && cur_digit <= 8 )
			    {
				    * pRes ++ = romanStr[romanIndex+1];
				    for( int tmp_index = 0; tmp_index < cur_digit - 5; tmp_index ++ )
				    {
					    * pRes ++ = romanStr[romanIndex];
				    }
			    }
			    else if( cur_digit == 9 )
			    {
				    * pRes ++ = romanStr[romanIndex];
				    * pRes ++ = romanStr[romanIndex+2];
			    }

			    num -= cur_digit * int( pow( 10.0, cur_count_digit - 1 ));
			    cur_count_digit --;
		    }
		    * pRes = '\0';
		    return string( res );
	    }

};
int main()
{
    Solution solution;

    for( int i = 1; i <= 3999; i++ )
    {
	    cout << i << " : " << solution.intToRoman( i ) << ( ( i % 5 == 0 ) ? "\n" : "\t" );
    }
    cout << endl;

    return 0;
}
