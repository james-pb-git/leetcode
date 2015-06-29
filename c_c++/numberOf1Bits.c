#include <stdio.h>

int hammingWeight( unsigned n) {
	int ans = 0;
	while( n != 0 )
	{
		ans += 1;
		n = n & ( n -1 );
	}
	return ans;
}

int main () {

	printf( "%d", hammingWeight (11 ));
	return 0;
}
