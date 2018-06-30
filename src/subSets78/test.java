package subSets78;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};		
		List<List<Integer>> list = subsets(nums);	
		for(List<Integer> subList : list) {
			for(Integer n : subList) {
				System.out.print(n+"  ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> returnList =  new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	returnList.add(list);
    	int[] flag = new int[nums.length];
    	findSubSets(nums,flag,returnList,0);
        return returnList;
    }
    
    public static void findSubSets(int[] nums, int[] flag, List<List<Integer>> returnList, int nowNumber) {
        for(int i = nowNumber; i < flag.length;i++) {
        	if(flag[i] == 0 ) {
        		flag[i] = 1;
        		returnList.add(findByBackTracking(nums,flag));    		
        		findSubSets(nums,flag,returnList,i+1);
        		flag[i] = 0;
        	}
        }
    }
    
    public static List<Integer> findByBackTracking(int[] nums, int[] flag) {
    	List<Integer> list = new ArrayList<>();
    	for(int i = 0;i < flag.length;i++){
    		if(flag[i] == 1){
    			list.add(nums[i]);
    		}
    	}
    	//if(list.size()) {
    		System.out.println("flag: " + flag[0] + "," + flag[1] + "," + flag[2]);
    	//}
    	return list;
    }	
}
