package binarySearchTreeIterator173;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
}

class BSTIterator {
	
	Stack<Integer> s = new Stack<>();
	
    public BSTIterator(TreeNode root) {
    	loadStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {         	
    	return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return s.pop();
    }
    
    private void loadStack(TreeNode root) {//load stack in descending order
        if (root == null) {
            return;
        }
        loadStack(root.right);
        s.push(root.val);
        loadStack(root.left);
    }
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}