package leetcode_in_java;

/**
 * Created by bopang on 18/3/19.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if( null == height || 0 == height.length )
            return 0;

        int maxAreaRes = 0;
        int left = 0;
        int right = height.length - 1;
        while( left < right ) {
            int curArea = ( right - left ) *
                    ( ( height[ left ] < height[ right ] ) ?
                            height[ left ] : height[ right ] );
            if( curArea > maxAreaRes )
                maxAreaRes = curArea;
            if( height[ left ] < height[ right ] )
                left ++;
            else
                right --;
        }
        return maxAreaRes;
    }
}
