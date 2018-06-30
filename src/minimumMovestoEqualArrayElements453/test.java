package minimumMovestoEqualArrayElements453;

public class test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		
		System.out.println(minMoves(nums));
	}
	
    public static int minMoves(int[] nums) {
    	if(nums == null || nums.length <= 1) return 0; 
        int min = Integer.MAX_VALUE;
        
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] < min) min = nums[i];
        	sum += nums[i];
        }
        
    	return sum - min*nums.length;
    }
}
