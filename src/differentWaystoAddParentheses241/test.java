package differentWaystoAddParentheses241;

import java.util.*;
public class test {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list = diffWaysToCompute(new String("2*3-4*5"));
		for(Integer n : list) {
			System.out.print(n+"  ");
		}
	}
	
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if(input == null || input.length() == 0) return list;
                
        return getResult(input, 0, input.length());
    }
	
    private static List<Integer> getResult(String input, int start, int end) {
    	List<Integer> list = new ArrayList<>();   	
    	//System.out.println(start+" "+end);
    	for(int i=start; i<end; i++) {
        	if((input.charAt(i) == '+') || (input.charAt(i) == '-') || (input.charAt(i) == '*')){
        		//System.out.println(i);
            	List<Integer> left = getResult(input,start,i);
            	List<Integer> right = getResult(input,i+1,end);
        		for(Integer l : left) {
        			for(Integer r : right) {
        				if(input.charAt(i) == '+') {
        					list.add(l+r);
        				} else if(input.charAt(i) == '-') {
        					list.add(l-r);
        				} else if(input.charAt(i) == '*') {
        					list.add(l*r);
        				}
        			}
        		}   		
        	}
    	}
    	//�����˼·�����ע��һ��.
    	if(list.size() == 0) {
    		String s = input.substring(start, end);   		
    		list.add(Integer.parseInt(s));
    	}
    	
    	return list;
    }
    
	/*
	 * ���ֻ�����˵��μ��㣬��ʵӦ���Ǽ���֮��ļ���
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        if(input == null || input.length() == 0) return list;
        for(int i=0; i<input.length(); i++) {
        	int res = 0;
        	if(input.charAt(i) == '+') {
        		res = getResult(input,0,i)+getResult(input,i+1,input.length());
        		list.add(res);
        	} else if(input.charAt(i) == '-') {
        		res = getResult(input,0,i)-getResult(input,i+1,input.length());
        		list.add(res);       		
        	} else if(input.charAt(i) == '*') {
        		res = getResult(input,0,i)*getResult(input,i+1,input.length());
        		list.add(res);      		
        	} else {
        		continue;
        	}
        }
    	
    	return list;
    }
    
    private static int getResult(String input, int start, int end) {
    	String s = new String("");
    	//����ԭ�����������˵������2*3+4,������е���һ��*��return��,��ʵӦ�����������,Ӧ�÷���һ��List
    	for(int i=start; i<end; i++) {
        	if(input.charAt(i) == '+') {
        		return getResult(input,start,i)+getResult(input,i+1,end);
        	} else if(input.charAt(i) == '-') {
        		return getResult(input,start,i)-getResult(input,i+1,end);     		
        	} else if(input.charAt(i) == '*') {
        		return getResult(input,start,i)*getResult(input,i+1,end);      		
        	} else {
        		s += input.charAt(i);
        		continue;
        	}   		
    	}
    	
    	return Integer.parseInt(s);
    }
    */
}
