package combinationSumFour377;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		int target = 32;
		System.out.println(combinationSum4(nums, target));
	}
	

	public static int combinationSum4(int[] nums, int target) {     
        int[] dp = new int[target];
        Arrays.fill(dp, -1);
        Arrays.sort(nums);
        int count = 0;
        for(int i=0; i<nums.length && target >=nums[i]; i++) {
        	count+= findByBackTracking(nums, target-nums[i], dp);
        }
        
		return count;
    }
	
	public static int findByBackTracking(int[] nums, int target, int[] dp) {
		if(target == 0) {
			return 1;
		} else if(dp[target] != -1) {
			return dp[target];
		} else {
			int count = 0;
			for(int i=0; i<nums.length && target >= nums[i]; i++) {
				count +=  findByBackTracking(nums, target-nums[i], dp);
			}
			dp[target] = count;
			return count;
		}
	}
}
