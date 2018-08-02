package findMinimuminRotatedSortedArray153;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{2,2,2,0,1};
		System.out.println(findMin(nums));
	}
	
    public static int findMin(int[] nums) {
        int min = 0;
        int left = 0, right = nums.length-1;
        while(left < right) {
        	int mid = (left+right)/2;
        	if(nums[mid] > nums[left]) {
        		left = mid;
        	} else if(nums[mid] < nums[left]) {
        		right = mid;
        	} else {
        		break;
        	}
        	//System.out.println(left+" "+mid+" "+right);
        }
    	min = Math.min(nums[left], nums[right]);
    	min = Math.min(min, nums[0]);
    	return min;
    }
} 
