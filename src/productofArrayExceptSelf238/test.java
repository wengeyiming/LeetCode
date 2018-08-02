package productofArrayExceptSelf238;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3,4,5};
		int[] res = productExceptSelf(nums);
		
		for(Integer n : res) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
	
	//space complexity o(1)
    public static int[] productExceptSelf(int[] nums) {
    	int[] res = new int[nums.length];
    	int right = 1;
    	res[0] = 1; 
        for(int i=1; i<nums.length; i++) {
        	res[i] = nums[i-1]*res[i-1];
        }
        for(int i=nums.length-1; i>=0; i--) {
        	res[i] = res[i]*right;
        	right = right*nums[i];
        }
        return res;
    }
	
	/*
	//space complexity o(n)
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        for(int i=1; i<nums.length; i++) {
        	left[i] = nums[i-1]*left[i-1];
        }
        for(int i=nums.length-2; i>=0; i--) {
        	right[i] = nums[i+1]*right[i+1];
        }
        for(int i=0; i<nums.length; i++) {
        	res[i] = left[i] * right[i];
        }
        return res;
    }
    */
}
