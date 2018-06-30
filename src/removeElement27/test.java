package removeElement27;

public class test {
	
	public static void main(String[] args) {
		int[] nums = new int[]{0,1,2,2,3,0,4,2};
		System.out.println(removeElement(nums,2));
		
	}
	
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
    	
    	int start = 0;
    	for(int i=0; i<nums.length; i++) {
    		if(nums[i] == val) {
    			
    		} else {
    			nums[start] = nums[i];
    			start++;
    		}
    	}
    	
    	/*
    	for(int i=0; i<nums.length; i++) {
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println("");
    	 */
    	
    	return start;
    }
}
