package implementStackusingQueues225;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
}


class MyStack {
	
	Queue<Integer> q1;
	Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()) {
        	q2.add(x);
        } else {
        	q1.add(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int num = 0;
        if(q1.isEmpty()) {        	
        	while(q2.size() > 1) {
        		num = q2.poll();
        		q1.add(num);
        	}     
        	num = q2.poll();
        } else {
        	while(q1.size() > 1) {
        		num = q1.poll();
        		q2.add(num);
        	}
        	num = q1.poll();
        }
        return num;
    }
    
    /** Get the top element. */
    public int top() {
    	int num = 0;
        if(q1.isEmpty()) {        	
        	while(!q2.isEmpty()) {
        		num = q2.poll();
        		q1.add(num);
        	}     
        } else {
        	while(!q1.isEmpty()) {
        		num = q1.poll();
        		q2.add(num);
        	}
        }
        return num;       
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}