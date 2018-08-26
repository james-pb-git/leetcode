package leetcode_in_java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by bopang on 8/26/18.
 */
public class FreqStack {

    /* WRONG IDEA */

    LinkedList<Integer> elements;
    HashMap<Integer, Integer> count;
    Stack<Integer> freqElement;
    int maxFreq = 0;

    public FreqStack() {
        elements = new LinkedList<Integer>();
        count = new HashMap<Integer, Integer>();
        freqElement = new Stack<Integer>();
        maxFreq = 0;
    }

    public void push(int x) {
        elements.add(x);
        if (count.containsKey(x))
            count.put(x, count.get(x) + 1);
        else
            count.put(x, 1);

        if (count.get(x) >= maxFreq || freqElement.isEmpty()) {
            maxFreq = count.get(x);
            freqElement.push(x);
        }
        else
            freqElement.push(freqElement.peek());
    }

    public int pop() {
        int val = freqElement.pop();
        if (count.get(val) > 1)
            count.put(val, count.get(val) - 1);
        else
            count.remove(val);
        for (int ind = elements.size() - 1; ind >= 0; ind --) {
            if (elements.get(ind) == val) {
                elements.remove(ind);
                break;
            }
        }
        return val;
    }

    public void test() {
        FreqStack fs = new FreqStack();
        fs.push(4);
        fs.push(0);
        fs.push(9);
        fs.push(3);
        fs.push(4);
        fs.push(2);
        fs.pop();
        fs.push(6);
        fs.pop();
        fs.push(1);
        fs.pop();
        fs.push(1);
        fs.pop();
        fs.push(4);
        fs.pop();fs.pop();fs.pop();fs.pop();fs.pop();fs.pop();
    }
}
