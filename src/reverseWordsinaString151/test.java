package reverseWordsinaString151;

import java.util.*;
public class test {
	
	public static void main(String[] args) {
		String s = new String("  the sky is blue ");
		System.out.println(reverseWords(s));
	}
	
    public static String reverseWords(String s) {
    	if(s == null || s.length() == 0) {
    		return s;
    	}
    	s = s.trim();
    	StringBuilder sb = new StringBuilder("");
    	Stack<Character> st = new Stack<>();
    	for(int i=s.length()-1; i>=0; i--) {
    		if(s.charAt(i) == ' ') {
    			if(!st.isEmpty()) {
    				while(!st.isEmpty()) {
    					sb.append(st.pop());
    				}
    				sb.append(' ');
    			} 			
    			
    		} else {
    			st.push(s.charAt(i));
    		}
    	}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
        return sb.toString();
    }
}
