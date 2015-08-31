package leetcode_in_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bopang on 15/8/21.
 */
class GrayCode {
    public List<Integer> grayCode(int n) {
        if( n < 0 )
            return null;
        List<Integer> ans = new ArrayList<Integer>();
        int idx = 1;
        int idxDiff = 0;
        int preGray = 0;
        ans.add( preGray );
        while( idx < ( 1 << n ) ) {
            idxDiff = idx ^ ( idx - 1);
            while( (idxDiff & ( idxDiff - 1)) != 0 ) {
                idxDiff = idxDiff & ( idxDiff - 1 );
            }
            preGray = preGray ^ idxDiff;
            ans.add( preGray);
            idx ++;
        }
        return ans;
    }
}
