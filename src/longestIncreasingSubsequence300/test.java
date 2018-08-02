package longestIncreasingSubsequence300;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
		
		System.out.println(lengthOfLIS(nums));
	}
	
    public static int lengthOfLIS(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	int[] tails = new int[nums.length];
    	int size = 0;
    	for(int x : nums) {
    		int i=0, j=size;
    		while(i != j) {
    			int m = (i+j)/2;
    			if(tails[m] < x) {
    				i = m+1;
    			} else {
    				j = m;
    			}
    		}
    		tails[i] = x;
    		if(i==size) size++;
    	}
    	
    	return size;
    }
	
	
	//O(n2) time complexity.
	/*
    public static int lengthOfLIS(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	int[] dp = new int[nums.length];
    	dp[0] = 1;
    	
    	for(int i=1; i<nums.length; i++) {
    		int j=i;
    		int tempMax = 0;
    		while(j>=0) {
    			if(nums[i] > nums[j]) {
    				if(tempMax < dp[j]) {
    					tempMax = dp[j];
    				}
    			}
    			j--;
    		}
    		dp[i] = tempMax+1;
    	}
    	
    	int  max = 0;
    	for(int i=0; i<dp.length; i++) {
    		if(dp[i] > max) {
    			max = dp[i];
    		}
    		//System.out.print(dp[i]+" ");
    	}
    	//System.out.println("");
    	return max;
    }
    */
}
