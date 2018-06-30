package combinationSum39;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] candidates = new int[]{2,3,5};
		int target = 8;
		List<List<Integer>> list = combinationSum(candidates, target);
		
		for(List<Integer> subs : list) {
			for(Integer s : subs) {
				System.out.print(s);
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> list = new ArrayList<>();
    	List<Integer> sub = new ArrayList<Integer>();
    	Arrays.sort(candidates);
    	findByBackTracking(candidates,target,list,0,sub,0);
    	return list;
    }	
    
    public static void findByBackTracking(int[] candidates, int target, List<List<Integer>> list, int sum, List<Integer> sub, int start) {
    	if(sum > target) {
    		return;
    	} else if(sum == target) {
    		//不知道为何要新建一个List才能添加进去
    		List<Integer> found = new ArrayList<Integer>(sub);
    		list.add(found);
    		return;
    	} else {
    		//要注意不能重复,所以要设置一个循环开始的起始位,这个思路要注意一下，可以很巧妙的解决问题。
    		for(int i=start; i<candidates.length; i++) {
    			sub.add(candidates[i]); 		
    			findByBackTracking(candidates,target,list,sum+candidates[i],sub,i);
    			sub.remove(sub.size()-1);
    		}
    	}
    }
    
}
