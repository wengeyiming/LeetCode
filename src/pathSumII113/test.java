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
    		//��Ϊ����Ҫreturn,����Ϊ�ǻ�����������Ҫremove,�������remove������ִ�в����ģ���������ҲҪremove
    		subList.remove(subList.size()-1);
    		return;
    	}    	
    	findAllPath(root.left, sum, now, list, subList);
    	findAllPath(root.right, sum, now, list, subList);    	  
    	//Ҫ������˼ά��ǰ��add��Ȼ�����������������������remove�������߼�
		subList.remove(subList.size()-1);		
    }
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}