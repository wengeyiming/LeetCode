package binaryTreeLevelOrderTraversalII107;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
        	return list;
        }   
        
        levelBFS(list, root, 0);
        
        return list;
    }
    
    
    //BFS搜索
    public static void levelBFS(List<List<Integer>> list, TreeNode root, int level) {
    	if(root == null) {
    		return;
    	}
    	//因为是倒序输出，所以在最开始位置添加新的list
    	if(level >= list.size()) {
    		list.add(0, new LinkedList<>());
    	}
    	
    	levelBFS(list, root.left, level+1);
    	levelBFS(list, root.right, level+1);
    	
    	//同样因为是倒序，所以要用list的size减去level.如果是正序则直接是level
    	list.get(list.size()-1-level).add(root.val);
    }
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
