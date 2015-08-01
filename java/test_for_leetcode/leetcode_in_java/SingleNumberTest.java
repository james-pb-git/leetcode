package leetcode_in_java;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by bopang on 15/7/31.
 */
public class SingleNumberTest {

    private SingleNumber singleNumber;

    @org.junit.Before
    public void setUp() throws Exception {
        singleNumber = new SingleNumber();
    }

    @org.junit.Test
    public void testSingleNumber() throws Exception {

        int[] testArr0 = { 0,1,2,3,2,3,0 };
        int ans0 = 1;
        assertEquals( ans0, singleNumber.singleNumber( testArr0 ));

    }
}