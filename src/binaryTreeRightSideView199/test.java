package binaryTreeRightSideView199;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();       	
        	for(int i=0; i<size; i++) {
        		TreeNode temp = queue.remove();
        		if(temp.left != null) {
        			queue.add(temp.left);
        		}
        		if(temp.right != null) {
        			queue.add(temp.right);
        		}        		
        		if(i == size - 1) {
        			list.add(temp.val);
        		}
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
