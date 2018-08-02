package findMinimuminRotatedSortedArrayII154;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{3,3,3,1,3,3,3,3};
		System.out.println(findMin(nums));
	}
	
    public static int findMin(int[] nums) {
        int min = 0;
        int left = 0, right = nums.length-1;
        while(left < right) {
        	int mid = (left+right)/2;
        	if(nums[mid] > nums[right]) {
        		left = mid+1;
        	} else if(nums[mid] < nums[right]){
        		right = mid;
        	} else {
        		right--;
        	}
        	//System.out.println(left+" "+mid+" "+right);
        }
    	return nums[left];
    }
}
