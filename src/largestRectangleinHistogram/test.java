package largestRectangleinHistogram;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] height = new int[]{2,1,5,6,2,3};
		
		System.out.println(largestRectangleArea(height));
	}
	
    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
        	System.out.println("i: " + i);
            int h = (i == len ? 0 : height[i]);
           // System.out.println("h: " + h);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
                for(int m : s) {
                	System.out.print(m+" ");
                }
                System.out.println("");
                System.out.println("");
            }else{
                int tp = s.pop();
                System.out.println("tp: " + tp);
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                //这里i--,循环里i++,所以i不变
                i--;
                System.out.println("max: " + maxArea);
                for(int m : s) {
                	System.out.print(m+" ");
                }
                System.out.println("");
            }

            
        }
        return maxArea;
    }
}
