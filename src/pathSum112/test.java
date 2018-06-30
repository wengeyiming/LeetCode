package pathSum112;

public class test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		
	}
	
    public static boolean hasPathSum(TreeNode root, int sum) {   	
    	return findByBackTracking(root,sum,0);
    }
    
    private static boolean findByBackTracking(TreeNode root, int sum, int now) {
    	if(root == null) {
    		return false;
    	}
    	
    	now += root.val;
    	if(root.left == null && root.right == null) {
    		if(now == sum) return true;
    		return false;
    	}
    	return findByBackTracking(root.left,sum,now) || findByBackTracking(root.right,sum,now);    	
    }
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}