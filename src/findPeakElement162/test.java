package findPeakElement162;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6};
		System.out.println(findPeakElement(nums));
	}
	
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left < right)
        {	
        	int mid = (left+right)/2;
        	if(nums[mid] < nums[mid+1]) {
        		left = mid+1;       		
        	} else {
        		right = mid;
        	}
        }
        return left;
    }
}
