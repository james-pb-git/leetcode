#include <iostream>
using namespace std;

class Solution {
	public:
		int totalNQueens(int n) {
			int ansNumber = 0;
			int * arrPosition = new int[ n ];
			int curCount = 0;

			// [ in ] arrPosition 当前已摆放的棋子所在的位置
			// [ in ] curCount 当前已摆放了多少个棋子
			// [ in ] 棋盘的尺寸
			// [ out ] ansNumber 记录已找到多少答案
			recursiveTotalNQueens( arrPosition, curCount, n, &ansNumber );
			delete [] arrPosition; // Don't forget this.
			return ansNumber;
		}
	private:
		// [ in ] index 下一个打算摆放的位置, 从 0 开始编号
		// 事实上，如果 index 命名为 position 可能会更便于理解
		bool isValidPosition( int arrPosition[], int curCount, int size, int index ) {
			for( int idx = 0; idx < curCount; idx ++ ) {
				if( index == arrPosition[ idx ] )
					return false;
				if( ( index - arrPosition[ idx ] ) == curCount - idx )
					return false;
				if( ( arrPosition[ idx ] - index ) == curCount - idx )
					return false;
			}
			return true;
		}

		void recursiveTotalNQueens( int arrPosition[], int curCount, int size, int *ansNumber ) {
			if( size <= 0 )
				return;
			if( curCount == size )
			{
				(*ansNumber)++; // 括号不能省略！
				return;
			}

			for( int index = 0; index < size; index ++ )
			{
				if( isValidPosition( arrPosition, curCount, size, index ) )
				{
					arrPosition[ curCount ] = index;
					recursiveTotalNQueens( arrPosition, curCount+1, size, ansNumber );
				}
			}
	}
};

int main () {

	Solution solution;
	for( int idx = 0; idx <= 10; idx ++ )
	{
		cout << idx << " : " << solution.totalNQueens( idx ) << endl;
	}
	return 0;
}
