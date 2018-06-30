package minimumSizeSubarraySum209;


public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{5,1,3,5,10,7,4,9,2,8};
		
		System.out.println(minSubArrayLen(15, nums));
	}
	
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
    	
        int start = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
        	sum += nums[i];
        	while(sum >= s) {
        		System.out.println("sum: " +sum);
        		sum -= nums[start++];        		
        		if(i-start+2 < minLength) {
        			minLength = i-start+2;
        		}
        		System.out.println("min: " +minLength);
        		
        	}
        }
        
    	return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
