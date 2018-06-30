package combinationSumTwo40;

//这个和一的区别在于一的数字没重复，每个位置的数字可以使用任意次。这个题目的数字有重复，但是每个位置的数字只能使用一次
import java.util.*;
public class test {
	public static void main(String[] args) {
		int[] candidates = new int[]{1,1,1,6};
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
    	int[] flag = new int[candidates.length];
    	findByBackTracking(candidates,target,list,0,sub,0, flag);
    	return list;
    }	
    
    public static void findByBackTracking(int[] candidates, int target, List<List<Integer>> list, int sum, List<Integer> sub, 
    		int start, int[] flag) {
    	if(sum > target) {
    		return;
    	} else if(sum == target) {
    		//不知道为何要新建一个List才能添加进去
    		List<Integer> found = new ArrayList<Integer>(sub);
    		list.add(found);
    		return;
    	} else {
    		Integer last = null;
    		//要注意不能重复,所以要设置一个循环开始的起始位,这个思路要注意一下，可以很巧妙的解决问题。
    		for(int i=start; i<candidates.length; i++) { 			
    			if(flag[i]==0 && (last == null || last != candidates[i])) {
    				sub.add(candidates[i]); 
    				flag[i] = 1;
    				//注意这里如果不用flag数组就是i+1,对应了数组只能用一次,类似于flag数组的效果
    				findByBackTracking(candidates,target,list,sum+candidates[i],sub,i, flag);
    				//到这里，其实就算已经完成了一次节点的回溯搜索了。所以要记录一下刚回溯的节点的数字，如果下一个节点的数字相同就跳过，避免重复
    				//为何不用flag数组：原因在于那个不能查重
    				flag[i] = 0;
    				last = sub.remove(sub.size()-1);
    			}
    		}
    	}
    }  
    
    /*
    public static void findByBackTracking(int[] candidates, int target, List<List<Integer>> list, int sum, List<Integer> sub, 
    		int start) {
    	if(sum > target) {
    		return;
    	} else if(sum == target) {
    		//不知道为何要新建一个List才能添加进去
    		List<Integer> found = new ArrayList<Integer>(sub);
    		list.add(found);
    		return;
    	} else {
    		Integer last = null;
    		//要注意不能重复,所以要设置一个循环开始的起始位,这个思路要注意一下，可以很巧妙的解决问题。
    		for(int i=start; i<candidates.length; i++) { 			
    			if(last == null || last != candidates[i]) {
    				sub.add(candidates[i]); 
    				//注意这里是i+1,对应了数组只能用一次
    				//注意这里是i+1,对应了数组只能用一次,类似于flag数组的效果
    				findByBackTracking(candidates,target,list,sum+candidates[i],sub,i+1);
    				//到这里，其实就算已经完成了一次节点的回溯搜索了。所以要记录一下刚回溯的节点的数字，如果下一个节点的数字相同就跳过，避免重复
    				//为何不用flag数组：原因在于那个不能查重
    				last = sub.remove(sub.size()-1);
    			}
    		}
    	}
    } 
    */
}


