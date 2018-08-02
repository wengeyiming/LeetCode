package increasingTripletSubsequence334;



public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{5,4,3,6,7};
		System.out.println(increasingTriplet(nums));
	}

    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) return false;
        
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        
        for(int x : nums) {
        	if(x <= first) {
        		first = x;
        	} else if(x < second) {
        		second = x;
        	} else if(x > second) {
        		return true;
        	}
        }
    	
    	return false;
    }
	
	/*
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) return false;
        int[] tails = new int[nums.length];
        int size = 0;
        for(int x : nums) {
        	int i=0, j=size;
        	while(i != j) {
        		int mid = (i+j)/2;
        		if(tails[mid] < x) {
        			i = mid+1;
        		} else {
        			j = mid;
        		}
        	}
        	
        	tails[i] = x;
        	if(i == size) {
        		size++;
        		if(size >= 3) return true;
        	}
        }
    	
    	return false;
    }
    */
}
