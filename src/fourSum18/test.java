package fourSum18;
import java.util.*;

//四个数字要求不重复，那么只需要保证前三个不重复，那么最后一个一定不重复
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{-3,-2,-1,0,0,1,2,3};
		List<List<Integer>> list = fourSum(nums, 0);
		
		for(List<Integer> l : list) {
			for(int m : l) {
				System.out.print(m+ " ");
			}
			System.out.println("");
		}
		
	}
	
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length<=3) return list;
        Arrays.sort(nums);

        for(int a=0; a<nums.length-3; a++) {
        	if(a>0 && nums[a]==nums[a-1]) continue;
        	for(int b=a+1; b<nums.length-2; b++) {
        		if(b>a+1 && nums[b] == nums[b-1]) continue;     		 
        		int c=b+1,d=nums.length-1;
        		while(c<d) {
        			int sum = nums[a]+nums[b]+nums[c]+nums[d];
        			if(sum<target) {
        				++c; continue;
        			} if(sum == target) {
        				list.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
        				++c;
        			}    				
        			--d;
        			while(c<d && nums[d]==nums[d+1]) {
        					--d;
        			}

        		}
        		
        	}
        }
              
        return list;
    }
}
