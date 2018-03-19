package leetcode_in_java;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bopang on 18/3/19.
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (null == J || null == S || J.length() == 0 || S.length() == 0)
            return 0;
        Set<Character> jewels = new HashSet<Character>();
        for (char j: J.toCharArray())
            jewels.add(j);
        int num = 0;
        for (char s: S.toCharArray()) {
            if (jewels.contains(s))
                num ++;
        }
        return num;
    }
}
