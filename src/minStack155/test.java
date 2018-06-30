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
        //��x ����СֵС��ʱ�򣬾���push��Сֵ��push x,����x��Ϊ�µ���Сֵ��������ͻ���žɵ���Сֵ������ɵ���Сֵ��λ�þͻᱻ����
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