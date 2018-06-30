package houseRobberII213;


public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2};
		System.out.println(rob(nums));
	}
	
    public static int rob(int[] nums) {  
    	if(nums == null || nums.length == 0) return 0;
    	if(nums.length == 1) return nums[0];
    	return Math.max(getMax(nums,0,nums.length-2), getMax(nums,1,nums.length-1));
    }
    
    private static int getMax(int[] nums, int left, int right) {

        int a=0;
        int b=0;
        int max = 0;
        
        for(int i=left; i<=right; i++) {
        	if(i % 2 == 0) {
        		a = Math.max(max, a+nums[i]);
        	} else {
        		b = Math.max(max, b+nums[i]);
        	}
        	max = Math.max(a, b);
        }       
        return max;
    }
}
