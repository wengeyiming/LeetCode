package validateBinarySearchTree98;


public class test {
	
	public static void main(String[] args) {
		
	}
	
    public boolean isValidBST(TreeNode root) { 
    	
        long lo = Long.valueOf(Integer.MIN_VALUE)-1L;
        long hi = Long.valueOf(Integer.MAX_VALUE)+1L;
        
        return isValidBST(root, lo, hi);

    }
    
    private boolean isValidBST(TreeNode root, long lo, long hi){
        if(root == null) return true;
        
        if(root.val <= lo || root.val >= hi) return false;
        
        boolean left = isValidBST(root.left, lo, root.val);
        boolean right = isValidBST(root.right, root.val, hi);
        return left&&right;
        

    }
    
    
    /*
    boolean returnValue = true;
	if(root != null) {
		if(root.left != null) {
			if(root.val <= root.left.val) {
				return false;
			} else {
				returnValue = returnValue && isValidBST(root.left);
			}
		}
		
		if(root.right != null) {
			if(root.val >= root.right.val) {
				return false;
			} else {
				returnValue = returnValue &&  isValidBST(root.right);
			}   			
		}
	}    	
	return returnValue;
	*/
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}