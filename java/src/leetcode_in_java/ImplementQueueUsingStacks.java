package leetcode_in_java;
import java.util.Stack;

/**
 * Created by bopang on 15/8/16.
 */
class ImplementQueueUsingStacks {
    public MyQueue myQueue;
}

class MyQueue {
    private Stack<Integer> stackForPush = new Stack<Integer>();
    private Stack<Integer> stackForPop = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        while( ! stackForPop.empty() ) {
            stackForPush.push( stackForPop.pop() );
        }
        stackForPush.push( x );
    }

    // Removes the element from in front of queue.
    public void pop() {
        while( ! stackForPush.empty() ) {
            stackForPop.push( stackForPush.pop() );
        }
        stackForPop.pop();
    }

    // Get the front element.
    public int peek() {
        while( ! stackForPush.empty() ) {
            stackForPop.push( stackForPush.pop() );
        }
        return stackForPop.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stackForPop.empty() && stackForPush.empty();
    }
}
