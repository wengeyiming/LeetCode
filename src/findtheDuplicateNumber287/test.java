package findtheDuplicateNumber287;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{3,2,1,2};
		System.out.println(findDuplicate(nums));
	}
	
	//two pointers
    public static int findDuplicate(int[] nums) {
    	if(nums.length <= 1) return -1;
        int low = nums[0];
        int fast = nums[0];
        
        do
        {
        	low = nums[low];
        	fast = nums[nums[fast]];
        	//System.out.println(low+" , " + fast);
        }while(low != fast);
        
        int find = nums[0];
        while(find != low) {
        	low = nums[low];
        	find = nums[find];
        }
        
    	return low;
    }	
	
	//binary Search
    public static int findDuplicate1(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low <= high) {
        	int mid = low + (high - low)/2;
        	System.out.println(low+" " + mid +" "+high);
        	int count = 0;
        	for(int num : nums) {
        		if(num <= mid) {
        			count++;
        		}
        	}
        	if(count > mid) {
        		high = mid-1;
        	} else {
        		low = mid+1;
        	} 
        	System.out.println(low+" " + mid +" "+high);
        }
    	return low;
    }
}
