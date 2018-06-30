package singleNumberII137;

public class test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,1,0,1,0,1,99};
		
		System.out.println(singleNumber(nums));
	}
	
    public static int singleNumber(int[] nums) {
    	int res = 0;
    	for(int i=0; i<32; i++) {
    		int sum = 0;
    		for(int j=0; j<nums.length; j++) {
    			sum = sum + ((nums[j] >> i) & 1);
    		}
    		//System.out.println(sum);
    		
    		res |= ((sum%3) << i);
    	}
    	return res;
    }
}
