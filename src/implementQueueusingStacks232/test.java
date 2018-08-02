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
       //���s2Ϊ�յ��ж�һ��Ҫ�ǵã��������1��2��3��Ȼ���¼�һ��4����Ϊ�վ�push 4������ǰ����
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