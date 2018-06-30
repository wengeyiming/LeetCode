package minimumMovestoEqualArrayElementsII462;

import java.util.Arrays;

public class test {	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		
		System.out.println(minMoves(nums));
	}
	
    public static int minMoves(int[] nums) {
    	if(nums == null || nums.length <= 1) return 0; 
    	Arrays.sort(nums);
    	
        int res = 0; 
        int mid = nums[nums.length/2];
        for(int i=0; i<nums.length; i++) {
        	res += Math.abs(nums[i]-mid);
        }
        
    	return res;
    }
}
