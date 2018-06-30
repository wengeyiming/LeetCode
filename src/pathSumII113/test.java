package pathSumII113;

import java.util.*;
public class test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		
	}
	
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        findAllPath(root,sum,0,list,subList);
        return list;
    }
    
    private static void findAllPath(TreeNode root, int sum, int now, List<List<Integer>> list, List<Integer> subList) {
    	if(root == null) {
    		return;
    	}    	
    	subList.add(root.val);
    	now += root.val;
    	if(root.left == null && root.right == null) {
    		if(now == sum) {
    			list.add(new ArrayList<>(subList));
    		} 
    		//因为这里要return,而因为是回溯搜索必须要remove,而下面的remove这里是执行不到的，所以这里也要remove
    		subList.remove(subList.size()-1);
    		return;
    	}    	
    	findAllPath(root.left, sum, now, list, subList);
    	findAllPath(root.right, sum, now, list, subList);    	  
    	//要有整体思维，前面add，然后搜索所有左右子树，最后remove。符合逻辑
		subList.remove(subList.size()-1);		
    }
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}