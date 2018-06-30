package maximumSubarray53;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{-2,-1};
		System.out.println(maxSubArray(nums));
	}
	
	public static int maxSubArray(int[] nums) {
        int maxNum = Integer.MIN_VALUE;       
        int num = 0;
        for(int i=0; i<nums.length; i++) {
    		num += nums[i];

        	if(num > maxNum) {
        		maxNum = num;
        	}
        	if(num < 0) {
        		num = 0;
        	}
        }    
        return maxNum;
    }
}
