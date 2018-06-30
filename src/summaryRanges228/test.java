package summaryRanges228;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{0,1};
		List<String> list = summaryRanges(nums);
		for(String s : list) {
			System.out.print(s + " ");
		}
		System.out.println("");
	}
	
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
        	return list;
        }
        int start = 0;
        for(int i=0; i<nums.length-1; i++) {
        	if(nums[i+1] == nums[i]+1) {
        		continue;
        	} else {
        		if(start != i) {
        			list.add(new String(nums[start]+"->"+nums[i]));
        		} else {
        			list.add(new String(nums[start]+""));
        		}
        		start = i+1;      		
        	}
        }
		if(start != nums.length-1) {
			list.add(new String(nums[start]+"->"+nums[nums.length-1]));
		} else {
			list.add(new String(nums[start]+""));
		}
    	return list;
    }
}
