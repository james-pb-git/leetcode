package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 15/8/24.
 */
class GenerateParentheses {
    private void generateParenthesis( int totalPair, int leftSoFar, int rightSoFar,
                                      int curPos, char[] tmpAns, List<String> finalAns ) {
        if( curPos == 2 * totalPair ) {
            finalAns.add( String.valueOf( tmpAns ) );
            return;
        }
        if( leftSoFar < totalPair ) {
            tmpAns[ curPos ] = '(';
            generateParenthesis( totalPair, leftSoFar + 1, rightSoFar, curPos + 1, tmpAns, finalAns );
        }
        if( rightSoFar < totalPair && rightSoFar < leftSoFar ) {
            tmpAns[ curPos ] = ')';
            generateParenthesis( totalPair, leftSoFar, rightSoFar + 1, curPos + 1, tmpAns, finalAns );
        }
    }

    public List<String> generateParenthesis(int n) {
        if( n < 0 )
            return null;
        List<String> ans = new ArrayList<String>();
        if( 0 == n )
            return ans;

        char[] tmpAns = new char[ 2 * n ];
        generateParenthesis( n, 0, 0, 0, tmpAns, ans );
        return ans;
    }
}
