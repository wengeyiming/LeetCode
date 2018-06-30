package removeDuplicatesfromSortedArray26;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,2,2,3};
		System.out.println(removeDuplicates(nums));
	}
	
    public static int removeDuplicates(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0;
    	}  	
    	int start=0;
    	for(int i=1; i<nums.length; i++) {
    		if(nums[start] == nums[i]) {
    			continue;
    		} else {
    			start++;
    			nums[start] = nums[i];
    		}
    		
    	}    
    	
    	
    	for(int i=0; i<nums.length; i++) {
    		System.out.print(nums[i]+" ");
    	}
    	System.out.println("");
    	
    	return start+1;
    }
}
