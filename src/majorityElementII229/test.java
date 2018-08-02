package majorityElementII229;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,3,2,3,1,3,2,4,5,6};
		List<Integer> res = majorityElement(nums);
	}
	
	
	//多数投票算法
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
    	if(nums == null || nums.length == 0) return list;
    	
    	int count1 = 0;
    	int count2 = 0;
    	int count3 = 0;
    	int candidate1 = 0;
    	int candidate2 = 1;
    	int candidate3 = 2;
    	for(int n : nums) {
    		if(n == candidate1) {
    			count1++;
    		} else if(n == candidate2) {
    			count2++;
    		} else if(n == candidate3) {
    			count3++;
    		} else if(count1 == 0) {
    			candidate1 = n;
    			count1 = 1;
    		} else if(count2 == 0) {
    			candidate2 = n;
    			count2 = 1;
    		} else if(count3 == 0) {
    			candidate3 = n;
    			count3 = 1;
    		} else {
    			count1--;
    			count2--;
    			count3--;
    		}
    	}
    	
    	System.out.println(candidate1 + " " + count1);
    	System.out.println(candidate2 + " " + count2);
    	System.out.println(candidate3 + " " + count3);
		count1 = 0; count2 = 0;
		for(int num : nums){
			if(num == candidate1) count1 ++;
			if(num == candidate2) count2 ++;
		}
		if(count1 > nums.length/3) list.add(candidate1);
		if(count2 > nums.length/3) list.add(candidate2);
    	return list;
    }
}
