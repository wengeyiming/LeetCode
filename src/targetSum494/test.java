package targetSum494;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 1, 1, 1};
		int S = 3;
		System.out.println(findTargetSumWays(nums, S));
	}
    public static int findTargetSumWays(int[] nums, int S) { 

    	int sum = 0;
    	for(int n : nums) {
    		sum += n;
    	}
    	
    	if(sum < S || ((S+sum)%2 > 0)) return 0;
    	return getByDP(nums, (S+sum)/2);
    }
	
    private static int getByDP(int[] nums, int newTarget) {
    	int[] dp = new int[newTarget+1];
    	
    	dp[0] = 1;
    	for(int n : nums) {
    		for(int i=newTarget; i>=n; i--) {
    			dp[i] += dp[i-n];
    		}
    	}
    	
    	return dp[newTarget];
    }
    
	/*
    public static int findTargetSumWays(int[] nums, int S) { 
        return findByDFS(nums, S, 0, 0);
    }
    
    private static int findByDFS(int[] nums, int target, int nowSum, int pos) {
    	if(pos == nums.length) {
        	if(nowSum == target) {
        		return 1;
        	}
    		return 0;
    	}
    	
    	int posNumber = nums[pos];
    	
    	return findByDFS(nums, target, nowSum+posNumber, pos+1)+ findByDFS(nums, target, nowSum-posNumber, pos+1);
    	
    }
    */
}
