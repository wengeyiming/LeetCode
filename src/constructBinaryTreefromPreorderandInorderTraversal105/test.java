package constructBinaryTreefromPreorderandInorderTraversal105;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
		int[] preorder = new int[]{3,9,1,4,20,15,7};
		int[] inorder = new int[]{1,9,4,3,15,20,7};
		
		TreeNode head = buildTree(preorder, inorder);
		
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(head);
		while(!queue.isEmpty()) {
			TreeNode temp =  queue.poll();
			if(temp != null) {
				System.out.print(temp.val + " ");
			}
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
		System.out.println("");
		
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {	
    	if(preorder.length != inorder.length || preorder.length == 0) {
    		return null;
    	}
		return identifyLeftOrRight(0, preorder.length-1, 0, preorder, inorder);
	}
	
	public static TreeNode identifyLeftOrRight(int instart, int inend, int preStart,int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || instart > inend) {
	        return null;
	    }
		TreeNode root = new TreeNode(preorder[preStart]);
		
		int mid = 0;
		for(int i=instart; i<=inend; i++) {
			if(inorder[i] == preorder[preStart]) {
				mid = i;
				break;
			}
		}
		
		root.left = identifyLeftOrRight(instart, mid-1, preStart+1, preorder, inorder);
		//root.right = identifyLeftOrRight(mid+1, inend, preStart+1, preorder, inorder);
		root.right = identifyLeftOrRight(mid+1, inend, preStart+1+mid-instart, preorder, inorder);
		return root;
	}
	
	/*
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length != inorder.length || preorder.length == 0) {
    		return null;
    	}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]); 
        queue.add(root);
        int popValue = root.val;
        for(int i=1; i<preorder.length; i++) {
        	int peekValue = queue.peek().val;
        	boolean hasChild = false;
        	boolean throughPop = false;
        	System.out.println(peekValue + " , " + preorder[i]);
        	for(int j=0; j<inorder.length; j++) {
        		if(inorder[j] == preorder[i]) {
        			queue.peek().left = new TreeNode(preorder[i]);
        			queue.add(new TreeNode(preorder[i]));
        			hasChild = true;
        			break;
        		} else if(inorder[j] == peekValue) {
        			queue.peek().right = new TreeNode(preorder[i]);
        			queue.add(new TreeNode(preorder[i]));
        			popValue = queue.poll().val;
        			hasChild = true;
        			break;
        		} else {        			
        			continue;
        		}
        	}
        	
        	if(!hasChild) {
        		TreeNode temp = queue.poll();
        		temp.left = null;
        		temp.right = null;
        	}
        	
        	System.out.print("queue:  ");
        	for(TreeNode m : queue) {
        		System.out.print(m.val + " ");
        	}
        	System.out.println("");
        	
        }
        
        
        return root;
    }
    */
    
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}