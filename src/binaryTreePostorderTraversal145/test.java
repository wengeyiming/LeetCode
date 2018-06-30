package binaryTreePostorderTraversal145;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //DFSËÑË÷
        while(root != null || !stack.empty()){
        	if(root != null) {
        		stack.push(root);
        		list.add(0,root.val);
        		root = root.right;
        	} else {
        		root = stack.pop();
        		root = root.left;
        	}
        	
        }
        return list;
    }
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}
