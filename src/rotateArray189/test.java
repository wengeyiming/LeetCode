package rotateArray189;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5,6,7};
		rotate(nums, 6);
		
		for(int n : nums) {
			System.out.print(n+" ");
		}
		System.out.println("");
	}
	
    public static void rotate(int[] nums, int k) {        
        int location = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,location-1);
        reverse(nums,location,nums.length-1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
    	while(start < end) {
    		int temp = nums[start];
    		nums[start++] = nums[end];
    		nums[end--] = temp;
    	}
    }
}
