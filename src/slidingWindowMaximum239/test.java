package slidingWindowMaximum239;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
		
		int[] res = maxSlidingWindow(nums, 3);
		for(int n : res) {
			System.out.print(n+" ");
		}
	}
	
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> dq = new LinkedList<Integer>();
        
        int[] res = new int[nums.length + 1 - k];
        //´¢´æ×ø±ê
        for(int i = 0; i < nums.length; i++){
        	if(!dq.isEmpty() && dq.peek() == i-k) {dq.poll();}
        	while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        		dq.removeLast();
        	}
        	dq.addLast(i);
        	if(i+1 >= k ) {
        		res[i-k+1] = nums[dq.peek()];
        	}
        }
        return res;
    }
}

