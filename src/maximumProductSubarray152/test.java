package maximumProductSubarray152;


public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{-2,3,-4};
		System.out.println(maxProduct(nums));
	}
	
    public static int maxProduct(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
        
    	int res = nums[0];
    	int preMin = nums[0];
    	int preMax = nums[0];
    	int curMin, curMax;
    	for(int i=1; i<nums.length; i++) {
    		curMin = Math.min(Math.min(preMax*nums[i], preMin*nums[i]),nums[i]);
    		curMax = Math.max(Math.max(preMax*nums[i], preMin*nums[i]),nums[i]);
    		
    		preMin = curMin;
    		preMax = curMax;
    		res = Math.max(res, curMax);
    	}
    	
    	return res;
    }
}
