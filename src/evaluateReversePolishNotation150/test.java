package evaluateReversePolishNotation150;

import java.util.*;
public class test {
	public static void main(String[] args) {
		String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		System.out.println(evalRPN(tokens));
	}
	
    public static int evalRPN(String[] tokens) {
        if(tokens.length == 1) {
        	return Integer.parseInt(tokens[0]);
        }
    	Stack<String> stack = new Stack<>();
		int result = 0;
    	for(int i=0; i<tokens.length; i++) {
    		if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ) {
    			int second = Integer.parseInt(stack.pop());
    			int first = Integer.parseInt(stack.pop());
 
    			if(tokens[i].equals("+")) {
    				result = first + second;
    			} else if(tokens[i].equals("-")) {
    				result = first - second;
    			} else if(tokens[i].equals("*")) {
    				result = first * second;
    			} else{
    				result = first / second;
    			}   
    			stack.push(result+"");
    		} else {
    			stack.push(tokens[i]);
    		}
    	}   	
    	return result;
    }
}
