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
using namespace std;

class Solution 
{
    public:    
        bool isMatch(const char *s, const char *p) {        
            const char* str1 = s;        
            const char* str2 = p;
            // States of str1: \0 or not
            // States of str2: \0, 
            //                 . / character followed by *
            //                 . / character followed by others

            
            // Assumption: *str2 != '*'
            
            if ( *str1 == '\0' )
            {
                if( *str2 == '\0' )
                    return true;
                if( *(str2+1) == '*' )
                    return isMatch( str1, str2 +2 );
                return false;
            }
            else
            {
                if( *str2 == '\0' )
                    return false;
                if( *( str2 + 1 ) == '*' )
                {
                    if( *str2 == '.' )
                    {
                        const char* tmp_str2 = str2+1;
                        while( *tmp_str2 == '*' )
                            tmp_str2 ++;

                        // .* stands for zero character.
                        if( isMatch( str1, tmp_str2 ) )
                                return true;

                        // .* stands for one or more character.
                        const char* tmp_str1 = str1;
                        // Attention: isMatch( "ab",".*" ) -> true.
                        // In this case, we don't expect str1 to contain all same characters.
                        while( *tmp_str1 != '\0' )
                        {
                            if( isMatch( tmp_str1+1, tmp_str2 ) )
                                return true;
                            tmp_str1 ++;
                        }
                        return false;
                    }
                    else
                    {
                        const char* tmp_str2 = str2+1;
                        while( *tmp_str2 == '*' )
                            tmp_str2 ++;

                        // .* stands for zero character.
                        if( isMatch( str1, tmp_str2 ) )
                                return true;

                        // .* stands for one or more character.
                        const char* tmp_str1 = str1;
                        while( *tmp_str1 == *str2 )
                        {
                            if( isMatch( tmp_str1+1, tmp_str2 ) )
                                return true;
                            tmp_str1 ++;
                        }
                        return false;
                    }
                }
                else
                {
                    if( *str2 == '.' || *str1 == *str2 )
                        return isMatch( str1+1, str2+1);
                    return false;
                }
            }
        }
};

int main()
{
//    int a = 257;
//    char Buf[5];

//    char* p = ( char* ) &a;

//    strncpy( Buf, p, 4 );

//    snprintf( str,4,"%s",*(char*)&a );
//
//    printf("%d\n",strlen(Buf));
    Solution solution;
    cout << solution.isMatch("aa","a") << endl;
    cout << solution.isMatch( "aa","aa") << endl;
    cout << solution.isMatch( "aaa","aa") << endl;
    cout << solution.isMatch( "aa","a*") << endl;
    cout << solution.isMatch( "aa",".*") << endl;
    cout << solution.isMatch( "ab",".*") << endl;
    cout << solution.isMatch( "aab","c*a*b") << endl;
    cout << solution.isMatch( "aaa","ab*a*c*a") << endl;
    return 0;
}





















/* vim: set expandtab ts=4 sw=4 sts=4 tw=100: */
