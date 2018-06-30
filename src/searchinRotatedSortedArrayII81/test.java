package searchinRotatedSortedArrayII81;

//允许重复，就会出现1,3,1,1,1 和 1,1,1,3,1 且target = 3的情况
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,1,3,1};
		
		System.out.println(search(nums,3));
	}
	
    public static boolean search(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length-1;
    	if(nums.length == 0) {
    		return false;
    	}
    	if(nums.length == 1) {
    		if(nums[left] == target) {
    			return true;
    		}
    	}     
    	
    	while(left <= right) {
    		int middle = (left+right)/2;
    		if(nums[middle] == target) {
    			return true;
    		} 
    		//System.out.println(nums[middle]);
    		if(nums[middle] > nums[left]) {
    			//2,3,4,5,6,7,0,1
    			if(nums[middle] > target && nums[left] <= target) {
    				right = middle-1;
    			} else {
    				left = middle+1;
    			}
    		} else if(nums[middle] < nums[left]){
    			//6,7,0,1,2,3,4,5
    			if(nums[middle] < target && nums[right] >= target) {
    				left = middle+1;
    			} else {
    				right = middle-1;
    			}
    		} else {
    			for(int i=left; i<=right; i++) {
    				if(nums[i] == target) {
    					return true;
    				}
    			}
    			return false;
    		}
    		//System.out.println(left+ " , " + right);
    	}    	
    	
    	return false;
    }
}
