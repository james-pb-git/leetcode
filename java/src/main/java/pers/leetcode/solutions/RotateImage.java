package pers.leetcode.solutions;

/**
 * Created by bopang on 15/8/31.
 */
class RotateImage {
    void swap_2d( int[][] array, int height1, int width1, int height2, int width2 ) {
        if( null == array || array.length == 0 || array[0].length == 0 )
            return;
        int buffer = 0;
        buffer = array[ height1 ][ width1 ];
        array[ height1 ][ width1 ] = array[ height2 ][ width2 ];
        array[ height2 ][ width2 ] = buffer;
    }

    private int[][] mirror( int[][] matrix ) {
        if( null == matrix || matrix.length == 0
                || matrix[0].length == 0 || matrix.length != matrix[0].length )
            return null;
        int size = matrix.length;
        for( int idx1 = 0; idx1 < size; idx1 ++ ) {
            for( int idx2 = 0; idx2 < size/2; idx2 ++ ) {
                swap_2d( matrix, idx1, idx2, idx1, size - 1 - idx2 );
            }
        }
        return matrix;
    }
    private int[][] transpose( int[][] matrix ) {
        if( null == matrix || matrix.length == 0
                || matrix[0].length == 0 || matrix.length != matrix[0].length )
            return null;
        int size = matrix.length;
        for( int idx1 = 1; idx1 < size; idx1 ++ ) {
            for( int idx2 = 0; idx2 < idx1; idx2 ++ ) {
                swap_2d( matrix, idx1, idx2, idx2, idx1 );
            }
        }
        return matrix;
    }

    public void rotate(int[][] matrix) {

        mirror( transpose( matrix ) );
    }
}
