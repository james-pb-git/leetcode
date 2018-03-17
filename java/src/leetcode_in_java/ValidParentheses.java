package leetcode_in_java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by bopang on 18/3/17.
 */
public class ValidParentheses {
    public boolean isValidSolution1(String s) {
        if(null == s || s.length() == 0)
            return true;

        Map<Character, Character> parenthesesPair = new HashMap<Character, Character>();
        parenthesesPair.put('(', ')');
        parenthesesPair.put('[', ']');
        parenthesesPair.put('{', '}');
        Stack<Character> parentheses = new Stack<Character>();
        int idx = 0;
        Character curChar = Character.MIN_VALUE;
        while (idx < s.length()) {
            curChar = s.charAt(idx);
            if (parenthesesPair.containsKey(curChar))
                parentheses.push(curChar);
            else if(parentheses.isEmpty() || curChar != parenthesesPair.get(parentheses.pop()))
                return false;
            idx ++;
        }
        return parentheses.isEmpty();
    }

    public boolean isValidSolution2(String s) {
        if(null == s || s.length() == 0)
            return true;

        Stack<Character> parentheses = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                parentheses.push(')');
            else if (c == '[')
                parentheses.push(']');
            else if (c == '{')
                parentheses.push('}');
            else if (parentheses.isEmpty() || c != parentheses.pop())
                return false;
        }
        return parentheses.isEmpty();
    }
}
