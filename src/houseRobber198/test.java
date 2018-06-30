package houseRobber198;

public class test {	
	public static void main(String[] args) {
		int[] nums = new int[]{4,1,1,3};
		System.out.println(rob(nums));
	}
	
    public static int rob(int[] nums) {
    	
        if(nums == null || nums.length == 0) return 0;
        int a=0;
        int b=0;
        int max = 0;
        
        for(int i=0; i<nums.length; i++) {
        	if(i % 2 == 0) {
        		a = Math.max(max, a+nums[i]);
        	} else {
        		b = Math.max(max, b+nums[i]);
        	}
        	max = Math.max(a, b);
        	System.out.println(a+" , "+b+" , "+max);
        }       
        return max;
    	
    	/*
        int prev = 0, curr = 0;
        for (int n : nums) {
            int tmp = curr;
            curr = Math.max(prev + n, curr);
            prev = tmp;
            System.out.println(prev + "," + curr);
        }
        return curr;   
    	*/       
    	/*
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int max = nums[0];
        int odd = nums[0];
        int even = nums[1];
        
        for(int i=2; i<nums.length; i++) {
        	if(i % 2 == 0) {
        		odd = Math.max(odd+nums[i],even);
        	} else {
        		even = Math.max(even+nums[i], odd);
        	}
        }
        
        
        return Math.max(odd, even);
        */
    }
}
