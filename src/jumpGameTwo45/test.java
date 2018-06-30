package jumpGameTwo45;

//求到终点的最小次数
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 3, 1, 1, 1, 4};
		
		System.out.println("max:  " + jump(nums));
	}
	
	// pos是下一步最远到达的距离，end是当前步最远到达的距离   
	public static int jump(int[] nums) {
		if(nums.length <2) return 0;
		int max = 0;
		int pos = 0;
		int end = 0;
		for(int i=0; i<nums.length; i++) {
    		if (nums[i] + i >= pos) {
    	        pos = nums[i] + i;
    		} 
    		if(pos >= nums.length-1) {
    			return max+1;
    		} 
    		if(i == end) {
    			max = max+1;
    			end = pos;
    		}		
		}
		return max;
    }
}
