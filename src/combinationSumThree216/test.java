package combinationSumThree216;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int times = 3;
		int target = 9;
		List<List<Integer>> list = combinationSum3(times, target);
		
		for(List<Integer> subs : list) {
			for(Integer s : subs) {
				System.out.print(s);
			}
			System.out.println("");
		}
	}
	
    public static List<List<Integer>> combinationSum3(int k, int n) {
    	List<List<Integer>> list = new ArrayList<>();
    	if(n>9*k) return list;
    	List<Integer> sub = new ArrayList<Integer>();
    	
    	findByBackTracking(k,n,list,0,sub,0,1);
    	return list;
    }	
    
    public static void findByBackTracking(int times, int target, List<List<Integer>> list, int sum, List<Integer> sub, 
    		int nowTime, int start) {
    	 if(nowTime == times) {
    		if(sum == target) {

    			List<Integer> found = new ArrayList<Integer>(sub);
    			list.add(found);
    		} 
    		return;
    	} else {
    		//要注意不能重复,所以要设置一个循环开始的起始位,这个思路要注意一下，可以很巧妙的解决问题。
    		for(int i=start; i<=9; i++) {
	    		sub.add(i); 		
	    		findByBackTracking(times,target,list,sum+i,sub,nowTime+1,i+1);
	    		sub.remove(sub.size()-1);
    		}
    	}
    }
}
