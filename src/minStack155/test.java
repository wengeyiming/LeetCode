package minStack155;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
}

class MinStack {

    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        //当x 比最小值小的时候，就先push最小值再push x,这样x身为新的最小值它的下面就会跟着旧的最小值，否则旧的最小值的位置就会被忘记
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}