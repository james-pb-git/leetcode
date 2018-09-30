package pers.leetcode.solutions;

import java.util.*;

/**
 * Created by bopang on 18/3/31.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (null == digits)
            return null;
        List<List<String>> res = new ArrayList<List<String>>();
        res.add(new ArrayList<String>());
        res.add(new ArrayList<String>());
        if(digits.contains("0") || digits.contains("1"))
            return res.get(0);
        Map<Character, String> letterMap = new HashMap<Character, String>();
        letterMap.put('2', "abc");
        letterMap.put('3', "def");
        letterMap.put('4', "ghi");
        letterMap.put('5', "jkl");
        letterMap.put('6', "mno");
        letterMap.put('7', "pqrs");
        letterMap.put('8', "tuv");
        letterMap.put('9', "wxyz");

        Character curDigit;
        for (int curIndex = 0; curIndex < digits.length(); curIndex ++) {
            curDigit = digits.charAt(curIndex);
            if (curIndex == 0) {
                for(Character ch : letterMap.get(curDigit).toCharArray())
                    res.get(0).add(ch.toString());
            }
            else {
                for (String comb : res.get(0)) {
                    for (Character ch : letterMap.get(curDigit).toCharArray()) {
                        res.get(1).add(new String(comb + ch));
                    }
                }
                Collections.swap(res, 0, 1);
                res.get(1).clear();
            }
        }
        return res.get(0);
    }
}
