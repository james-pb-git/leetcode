package leetcode_in_java;

/**
 * Created by bopang on 15/8/8.
 */
class NQueensII {
    private int total_ans = 0;

    private boolean isValidMove( int trial, int curStep, int size, int[] curSolution ) {
        for( int idx = 0; idx < curStep; idx ++ ) {
            if( curSolution[ idx ] == trial )
                return false;
            if( curSolution[ idx ] - trial == idx - curStep )
                return false;
            if( curSolution[ idx ] - trial == curStep - idx )
                return false;
        }
        return true;
    }

    private void iterativeNQueens( int curStep, int size, int[] solution ) {
        if( curStep == size ) {
            total_ans += 1;
            return;
        }
        for( int idx = 0; idx < size; idx ++ ) {
            if( isValidMove( idx, curStep, size, solution ) ) {
                solution[ curStep ] = idx;
                iterativeNQueens( curStep + 1, size, solution );
                solution[ curStep ] = 0; // Useless
            }
        }
    }
    public int totalNQueens(int n) {
        if( 0 >= n )
            return 0;
        int[] solution = new int[n];
        iterativeNQueens( 0, n, solution );
        return this.total_ans;
    }
}
