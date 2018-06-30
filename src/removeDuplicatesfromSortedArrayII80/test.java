package removeDuplicatesfromSortedArrayII80;

//和I不同的是每个数字可以出现最多n=2次。可以考虑当n=3,4,5时的通解。
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,1,3,3,3,4,5,5,5};
		System.out.println(removeDuplicates(nums));
	}
	
    public static int removeDuplicates(int[] nums) {
	
    	if(nums.length <= 2) {
    		return nums.length;
    	}
        
        int j = 0;
        for(int i = 0; i<nums.length-2; i++) {
            if(nums[i] != nums[i+2]){
                nums[j] = nums[i];
                j++;
            }
        }
        nums[j++] = nums[nums.length-2];
        nums[j++] = nums[nums.length-1];
       
    	
    	return j;
    }
}
