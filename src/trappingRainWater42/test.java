package trappingRainWater42;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
		int[] height = new int[]{4,2,0,3,2,5};
		
		System.out.println(trap(height));
	}
	
    public static int trap(int[] height) {
        int volume = 0;
        
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<height.length; i++) {
        	if(s.isEmpty()|| height[i] <= height[s.peek()]) {
        		s.push(i);
        	} else {     		
        		while(!s.isEmpty() && height[i] > height[s.peek()]) { 
        			/*
        			System.out.print("stack:  ");
                    for (Integer x : s) {   
                        System.out.print(x+" ");   
                    }   
        			System.out.println(""); 
        			*/       			   
        			int temp = s.pop();

        			if(!s.isEmpty()) {
	        			int min = Math.min(height[s.peek()]-height[temp], height[i]-height[temp]);        			        			
	        			//核心部分搞错了啊,注意一下
	        			volume = volume + min*(i-s.peek()-1);
	        			//System.out.println("volume, min, i, temp: " + volume +" " + min +" " + i + " " + temp);
        			}
        		}  
        		//System.out.println("loop");
        		s.push(i);
        		
        	}
        }           
        return volume;
        
        /*
        int volume = 0;       
        Stack<Integer> s = new Stack<>();
        int i = 0; 
        int n = height.length;
        //注意用while循环不要用for循环
        while(i < n) {
        	if(s.isEmpty()|| height[i] <= height[s.peek()]) {
        		s.push(i++);
        	} else {     	       		
        		int temp = s.pop();
        		if (s.isEmpty()) continue;       		
        		int min = Math.min(height[s.peek()]-height[temp], height[i]-height[temp]);
        		volume = volume + min * (i-s.peek()-1);        		
        	}
    	}  
        return volume;
        */
    }
}
