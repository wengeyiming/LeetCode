package permutationsTwo47;

//返回带重复数字的全排列
import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,1,2,1};
		List<List<Integer>> list = permuteUnique(nums);
		
		for(List<Integer> subList : list) {
			for(Integer a : subList) {
				System.out.print(a+ "  ");
			}
			System.out.println("");
		}
		
	}
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        int[] flag = new int[nums.length];
        Arrays.sort(nums);
        findByBackTracking(list, subList, nums, 0, flag);
        return list;        
    }
    
    public static void findByBackTracking(List<List<Integer>> list, List<Integer> subList, int[] nums, int nowNum, int[] flag) {
    	if(nowNum == nums.length) {
    		List<Integer> addList = new ArrayList<Integer>(subList);
    		list.add(addList);
    		return;
    	} 
    	
    	Integer last = null;
    	for(int i=0; i<nums.length; i++) {
    		if(flag[i] == 0 && (last == null || last != nums[i])) {
	    		subList.add(nums[i]);
	    		flag[i] = 1;
	    		findByBackTracking(list, subList, nums, nowNum+1, flag);
	    		last = subList.remove(subList.size()-1);	  
	    		flag[i] = 0;
    		}
    	}
    }
}
