package oneThreeTwiPattern456;

import java.util.*;

public class test {
	public static void main(String[] args) {
		int[] nums1 = new int[] { 4, 5, 3, 2, 4 };
		//int[] nums1 = new int[] { 3, 5, 0, 3, 4 };
		int[] nums2 = new int[] { 1, 0, 1, -4, -3 };

		System.out.println(find132pattern(nums1));
		System.out.println(find132pattern(nums2));
	}
	
	public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
        	if (nums[i] < second) return true;
        	else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = stack.pop();
                }   
        	}
           stack.push(nums[i]);
       }
       return false;
	}
	
	/*
	public static boolean find132pattern(int[] nums) {
		if (nums == null || nums.length <= 2)
			return false;	
		Stack<Integer> s = new Stack<>();	
		int min = nums[0];
		s.push(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > s.peek()) {
				s.push(nums[i]);
				continue;
			}
			while (s.size() > 0 && nums[i] <= s.peek()) {
				s.pop();

				if (s.size() > 0 && nums[i] > s.peek()) {
					return true;
				}
			}
			s.push(nums[i]);
		}
		return false;
	}
	*/

}
