#include <stdio.h>

int titleToNumber(char *s) {
    unsigned ans = 0;
    char * p = s;
    while( p != NULL && *p != '\0' ) {
        if( (*p < 'A') || (*p > 'Z') ) {
            return 0;
        }
        ans = ans * 26 + ( *p - 'A' ) + 1;
        p ++;
    }
    return ans;
}

int main () {

	printf( "%d\n", titleToNumber ( "AA" ) );
	return 0;
}
