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
using namespace std;

class Solution {
    public:
        int romanCharacterToInt( char ch ) {
            bool valid = false;
            if( ( ch <= 'z' ) && ( ch >= 'a' ) )
            {
                ch += 'A' - 'a';
                valid = true;
            }
            else if( ( ch <= 'Z' ) && ( ch >= 'A' ) )
            {
                valid = true;
            }
            if( !valid )
                return 0;

            switch( ch )
            {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                return 0;
            }
        }

        int romanToInt(string s) {
            if( s.length() == 0 )
                return 0;
            int res = 0;
            int pre_value = 10000;
            int cur_value = 0;

            char cur;
	    unsigned cur_index = 0;

            while( cur_index < s.length() )
            {
		cur = s[cur_index];
                cur_value = romanCharacterToInt( cur );
                if( cur_value <= pre_value )
                {
                    res += cur_value;
                    pre_value = cur_value;
                }
                else
                {
                    res += cur_value - 2 * pre_value;
                    pre_value = cur_value;
                }
		cur_index ++;
            }
            return res;
    }
};
int main()
{
    Solution solution;

    string test1 = "I"; // 1
    string test2 = "VII"; // 7
    string test3 = "IX"; // 9
    string test4 = "XX"; // 20
    string test5 = "XXXIV"; // 34
    string test6 = "XCV"; // 95
    string test7 = "CMXCIX"; // 999
    string test8 = "MCMLXXXIV"; // 1984
    string test9 = "MMMCMXCIX"; // 3999

    cout << solution.romanToInt( test1 ) << endl;
    cout << solution.romanToInt( test2 ) << endl;
    cout << solution.romanToInt( test3 ) << endl;
    cout << solution.romanToInt( test4 ) << endl;
    cout << solution.romanToInt( test5 ) << endl;
    cout << solution.romanToInt( test6 ) << endl;
    cout << solution.romanToInt( test7 ) << endl;
    cout << solution.romanToInt( test8 ) << endl;
    cout << solution.romanToInt( test9 ) << endl;

    return 0;
}
