package containsDuplicateII219;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,1,1};
		
		System.out.println(containsNearbyDuplicate(nums, 2));
	}
	
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
    	
        for(int i=0; i<nums.length; i++) {
        	if(map.containsKey(nums[i])) {       		
        		if(i-map.get(nums[i]) <= k) {
        			return true;
        		}
        		map.put(nums[i], i);
        	} else {
        		map.put(nums[i], i);
        	}
        }   	   	
    	return false;
    }
}
