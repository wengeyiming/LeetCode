package countCompleteTreeNodes222;

import java.util.*;
public class test {
	public static void main(String[] args) {
		System.out.println(1<<2);
	}
	

    public static int countNodes(TreeNode root) {
    	if(root == null) return 0; 
    	
    	int hRoot = height(root);
    	int hRight = height(root.right);
    	if(hRight == hRoot-1) {
    		return 1<<(hRoot-1) + countNodes(root.right);
    	} else {
    		return 1<<(hRoot-2) + countNodes(root.left);
    	}   	
    }
    
    private static int height(TreeNode root) {
    	if(root == null) return 0;
    	return 1+height(root.left);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}