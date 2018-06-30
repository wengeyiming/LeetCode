package subSetsTwo92;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};		
		List<List<Integer>> list = subsetsWithDup(nums);	
		for(List<Integer> subList : list) {
			for(Integer n : subList) {
				System.out.print(n+"  ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> list = new ArrayList<>();
    	Arrays.sort(nums);   	
    	findByBackTracking(nums,list,new ArrayList<Integer>(),0);
    	return list;
    }	
    
    public static void findByBackTracking(int[] nums, List<List<Integer>> list, List<Integer> subList, int nowNum) {	
    	list.add(new ArrayList<Integer>(subList));
    	Integer last = null;
    	for(int i=nowNum; i<nums.length; i++) {
    		if(last == null || last != nums[i]) {
    			subList.add(nums[i]);
    			//注意这里是i+1，而不是nowNum+1.
    			findByBackTracking(nums,list,subList,i+1);
    			last = subList.remove(subList.size()-1);    			
    		}
    	}
    }
    
   public static void addSubset(List<List<Integer>> result,List<Integer> list,int start,int[] nums){
        result.add(new ArrayList<Integer>(list));
        Integer last = null;
        for(int i = start;i < nums.length;i++){
        	if(last == null || last != nums[i]) {
	            list.add(nums[i]);
	            addSubset(result,list,i+1,nums);
	            last = list.remove(list.size() - 1);
        	}
        }
    }
}
