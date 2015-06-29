#include <iostream>
using namespace std;

class Solution {
	public:
		int totalNQueens(int n) {
			int ansNumber = 0;
			int * arrPosition = new int[ n ];
			int curCount = 0;

			// [ in ] arrPosition ��ǰ�Ѱڷŵ��������ڵ�λ��
			// [ in ] curCount ��ǰ�Ѱڷ��˶��ٸ�����
			// [ in ] ���̵ĳߴ�
			// [ out ] ansNumber ��¼���ҵ����ٴ�
			recursiveTotalNQueens( arrPosition, curCount, n, &ansNumber );
			delete [] arrPosition; // Don't forget this.
			return ansNumber;
		}
	private:
		// [ in ] index ��һ������ڷŵ�λ��, �� 0 ��ʼ���
		// ��ʵ�ϣ���� index ����Ϊ position ���ܻ���������
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
				(*ansNumber)++; // ���Ų���ʡ�ԣ�
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
