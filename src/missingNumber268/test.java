package missingNumber268;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{9,6,4,2,3,5,7,8,1};
		System.out.println(missingNumber(nums));
	}
	
    public static int missingNumber(int[] nums) {
    	
    	int sum = 0;
    	int n = nums.length;
        for(int i=0; i<nums.length; i++) {
        	sum += nums[i];
        }
        
        return n*(n+1)/2 - sum;
        
    }
}
