package binaryTreePreorderTraversal144;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        

        while(root!=null||!stack.empty()){
        	if(root != null) {
        		stack.push(root);
        		list.add(root.val);
        		root = root.left;
        	} else {
        		root = stack.pop();
        		root = root.right;
        	}
        	
        }

              
        //preorderDFS(root, list);
        return list;
    }
    
    /*
    private static void preorderDFS(TreeNode root, List<Integer> list) {
    	if(root == null) return;
    	
    	list.add(root.val);
    	preorderDFS(root.left, list);
    	preorderDFS(root.right, list);
    }
    */
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}