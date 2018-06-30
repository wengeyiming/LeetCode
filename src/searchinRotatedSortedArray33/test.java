package searchinRotatedSortedArray33;

//规定了时间复杂度为logn
import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{4,5,0,1,2};
		
		System.out.println(search(nums,5));
	}
	
    public static int search(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length-1;
    	if(nums.length == 0) {
    		return -1;
    	}
    	if(nums.length == 1) {
    		if(nums[left] == target) {
    			return left;
    		}
    	} 
    	
    	while(left <= right) {
    		int middle = (left+right)/2;
    		if(nums[middle] == target) {
    			return middle;
    		} 
    		
    		if(nums[middle] >= nums[left]) {
    			//2,3,4,5,6,7,0,1
    			if(nums[middle] > target && nums[left] <= target) {
    				right = middle-1;
    			} else {
    				left = middle+1;
    			}
    		} else {
    			//6,7,0,1,2,3,4,5
    			if(nums[middle] < target && nums[right] >= target) {
    				left = middle+1;
    			} else {
    				right = middle-1;
    			}
    		}
    		
    	}
    	
    	
    	return -1;
    }	

}
