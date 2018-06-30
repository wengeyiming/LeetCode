package symmetricTree101;


public class test {
	public static void main(String[] args) {
		
	}
	
    public static boolean isSymmetric(TreeNode root) {      
    	if(root == null) {
    		return true;
    	}   	
    	if(root.left == null && root.right == null) {
    		return true;
    	} else if(root.left != null && root.right != null) {
    		return check(root.left,root.right);
    	} else {
    		return false;
    	}

    }
    
    private static boolean check(TreeNode left, TreeNode right) {
    	
    	if(left == null && right == null) {
    		return true;
    	} else if(left != null && right != null) {
    		if(left.val != right.val) {
    			return false;
    		} else {
    			return check(left.right, right.left) && check(left.left, right.right);
    		}
    	} else {
    		return false;
    	}
    }
    
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}