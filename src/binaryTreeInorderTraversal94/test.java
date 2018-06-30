package binaryTreeInorderTraversal94;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        //DFS�������Ȱ����е�������push��ջ�У�Ȼ��ÿpopһ����push������
        while(root != null || !stack.empty()){
        	if(root != null) {
        		stack.push(root);
        		root = root.left;
        	} else {
        		root = stack.pop();
        		list.add(root.val);
        		root = root.right;
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
