package searchInsertPosition35;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6};
		
		System.out.println(searchInsert(nums, 2));
	}
	
	public static int searchInsert(int[] nums, int target) {        
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] >= target) {
        		return i;
        	} 
        }
        return nums.length;
    }
}
