package permutations46;

//返回不带重复数字的全排列
//如果不允许对nums排序，可以用一个HashSet，遇到一个数字时检查如果不在HashSet中才能回溯，并将其加入到HashSet中
import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,1,2};
		List<List<Integer>> list = permute(nums);
		
		for(List<Integer> subList : list) {
			for(Integer a : subList) {
				System.out.print(a+ "  ");
			}
			System.out.println("");
		}
		
	}
	
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        int[] flag = new int[nums.length];
        findByBackTracking(list, subList, nums, 0, flag);
        return list;
    }	
    
    public static void findByBackTracking(List<List<Integer>> list, List<Integer> subList, int[] nums, int nowNum, int[] flag) {
    	if(nowNum == nums.length) {
    		List<Integer> addList = new ArrayList<Integer>(subList);
    		list.add(addList);
    		return;
    	} 
    	

    	for(int i=0; i<nums.length; i++) {
    		if(flag[i] == 0) {
	    		subList.add(nums[i]);
	    		flag[i] = 1;
	    		findByBackTracking(list, subList, nums, nowNum+1, flag);
	    		subList.remove(subList.size()-1);	  
	    		flag[i] = 0;
    		}
    	}
    }
}
