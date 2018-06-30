package jumpGame55;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};

		System.out.println(canJump(nums));

	}
	
    public static boolean canJump(int[] nums) {  
    	//记录当前能到达的最大位置.
    	int pos = 0;
    	for(int i=0; i<nums.length; i++) {
    		if(pos < i) { 
    			return false;
    		}
    		if (nums[i] + i > pos) {
    	        pos = nums[i] + i;
    		}
    		System.out.println(pos);
    	}
    	return true;
    	
    	//这个算法是错误的，错误原因比较复杂
    	//以上面的例子为例，第一个数字是5，所以此算法判断前面5个数字内最远的是第二个数字9，能走到10，但是忽略了10前面的数字加上后大于10的情况，
    	//漏了判断。
    	/*
    	if(nums.length == 1) return true;
    	int max = 0;   	
    	int i=0;
    	int li = 0;
    	while(i<nums.length-1) {
    		max = 0;
			if(i+nums[i] >= nums.length-1) {
				return true;
			}
    		for(int j=0; j<=nums[i]; j++) {
    			if(nums[i+j] + i+j > max) {
    				max = nums[i+j] + i+j;
    			}
    		}
    		i = max;
    		System.out.println("max:  " + max + "   , i: "+i);
    		if(max <= 0) {
    			return false;
    		} 

    		if(i == li) {
    			return false;
    		}
    		li = i;
    	}
    	
    	return true;
    	*/
    }	
}
