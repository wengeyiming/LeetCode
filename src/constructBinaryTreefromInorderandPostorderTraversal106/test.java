package constructBinaryTreefromInorderandPostorderTraversal106;

import java.util.LinkedList;
import java.util.Queue;


public class test {
	public static void main(String[] args) {
		
		//int[] inorder = new int[]{9,3,15,20,7};
		//int[] postorder = new int[]{9,15,7,20,3};
		int[] inorder = new int[]{1,9,4,3,15,20,7};		
		int[] postorder = new int[]{1,4,9,15,7,20,3};
		TreeNode head = buildTree(inorder, postorder);		
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

	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {	
    	if(postorder.length != inorder.length || postorder.length == 0) {
    		return null;
    	}
		return helper(0, inorder.length-1, postorder.length-1, inorder, postorder);
	}
	
	public static TreeNode helper(int instart, int inend, int postend, int[] inorder, int[] postorder) {		
		if(instart > inend || postend < 0) {
			return null;
		}
		
		TreeNode root = new TreeNode(postorder[postend]);		
		int mid = 0;
		
		for(int i=instart; i<=inend; i++) {
			if(inorder[i] == postorder[postend]) {
				mid = i;
				break;
			}
		}
	
		root.left = helper(instart, mid-1, postend-1-(inend-mid), inorder, postorder);
		root.right = helper(mid+1, inend, postend-1, inorder, postorder);		
		return root;
	}
	/*
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }
    private static TreeNode dfs(int posStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (posStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posStart]);
        int inIndex = 0;
        for (; inIndex <= inEnd; inIndex++) {
            if (inorder[inIndex] == root.val) {
                break;
            }
        }
        root.left = dfs(posStart + inIndex - inEnd - 1, inStart, inIndex - 1, postorder, inorder);
        root.right = dfs(posStart - 1, inIndex + 1, inEnd, postorder, inorder);
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