package validParentheses20;

import java.util.*;
public class test {
	public static void main(String[] args) {	
		System.out.println(isValid(new String("]")));
	}
	
    public static boolean isValid(String s) {
    	char[] c = s.toCharArray();
    	Stack<Character> stk = new Stack<>();
    	
    	int leftNum = 0;
    	for(int i=0; i<c.length; i++) {
    		if(c[i]=='(') {
    			stk.push(c[i]);
    			leftNum++;
    		} else if(c[i]=='[') {
    			stk.push(c[i]);
    			leftNum++;
    		} else if(c[i]=='{') {
    			stk.push(c[i]);
    			leftNum++;
    		} else if(c[i]==')') {
    			if(stk.size()<=0) {
    				return false;
    			}
    			if(stk.pop() != '(') {
    				return false;
    			}
    			leftNum--;
    		} else if(c[i]=='}') {
    			if(stk.size()<=0) {
    				return false;
    			}
    			if(stk.pop() != '{') {
    				return false;
    			}
    			leftNum--;
    		} else if(c[i]==']') {
    			if(stk.size()<=0) {
    				return false;
    			}
    			if(stk.pop() != '[') {
    				return false;
    			}
    			leftNum--;
    		} else {
    			return false;
    		}
    	}
        return leftNum==0? true:false;
    }
}
