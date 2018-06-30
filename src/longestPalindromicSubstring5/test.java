package longestPalindromicSubstring5;
import java.util.*;

//��������ַ�������̬�滮�㷨���ѵ����ڶ���ż�Ĵ���
public class test {
	public static void main(String[] args) {
		String s = new String("ab");
		System.out.println(longestPalindrome(s));
	}
	
    public static String longestPalindrome(String s) {
    	if(s.length() <= 1) return s;
    	String sub = new String("");   	
    	char[] c = s.toCharArray();
		int start;
		int end;
    	//odd
    	for(int i=0; i<c.length; i++) {
    		start = end = i;
    		while(start>=0 && end <=c.length-1 && c[start] == c[end]) {
        		if(end-start+1 > sub.length()) {
        			sub = s.substring(start,end+1);
        		}
    			start--;
    			end++;  	
    		}		
    	}
    	//even
    	for(int i=0; i<c.length; i++) {
    		start = i;
    		end = i+1;
    		while(start>=0 && end <=c.length-1 && c[start] == c[end]) {
        		if(end-start+1 > sub.length()) {
        			sub = s.substring(start,end+1);
        		}
    			start--;
    			end++;  	
    		}		
    	}   	
	
    	return sub;
    	
    	/*
    	for(int i=c.length/2; i<c.length-1; i++) {
    		for(int j=1; j<c.length-i; j++) {
	    		if(c[i-j] == c[i+j]) {
	    			System.out.println("continue");
	    			if(j*2+1 > maxLength) {
	    				maxLength = 2*j+1;
	    				sub = s.substring(i-j,i+j+1);				
	    			}
	    		}
	    		else {
	    			break;
	    		} 
    		}
    	}*/   
    }

}
