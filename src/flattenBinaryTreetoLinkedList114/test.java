package flattenBinaryTreetoLinkedList114;

public class test {
	public static void main(String[] args) {
		
	}
	
	
    public static void flatten(TreeNode root) {
    	if(root == null) return;
    	while(root.left != null) {  		
    		TreeNode temp = root.left;
    		while(temp.right != null) {
    			temp = temp.right;
    		}
    		TreeNode right = root.right;
    		root.right = root.left;
    		root.left = null;
    		temp.right = right;
    		
    		root = root.right;
    	}
    	
    	/*
    	if(root == null) return;
    	while(root != null) {  	
            if(root.left != null) {
	    		TreeNode temp = root.left;
	    		while(temp.right != null) {
	    			temp = temp.right;
	    		}
	            temp.right =  root.right;
	    		root.right = root.left;
	    		root.left = null;
            }
    		
    		
    		root = root.right;
    	}
    	*/
    }

	/*
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
    	root.right = root.left;
    	root.left = null;
    	while(root.right != null) {
    		root = root.right;
    	}
    	root.right = temp;
    	
    }
    
    */
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}