package implementQueueusingStacks232;

import java.util.*;
public class test {

}

class MyQueue {
	
	Stack<Integer> s1;
	Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       //这个s2为空的判断一定要记得，否则比如1，2，3。然后新加一个4，不为空就push 4就跑最前面了
       if(s2.isEmpty()) {
	       while(!s1.isEmpty()) {
	    	   s2.push(s1.pop());
	       }
       }
       return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}