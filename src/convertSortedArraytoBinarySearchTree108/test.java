package convertSortedArraytoBinarySearchTree108;

public class test {
	public static void main(String[] args) {		
		int[] nums = new int[]{-10,-3,0,5,9};		
		TreeNode root = sortedArrayToBST(nums);
		
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;      
        TreeNode root = buildBSTTree(nums, 0, nums.length-1);		
		return root;
    }
	
	private static TreeNode buildBSTTree(int[] nums, int low, int high) {
		if(low > high) return null;		
		//求中值的时候一定注意是+不是- !
		int index = (high+low)/2;
		TreeNode root = new TreeNode(nums[index]);		
		root.left = buildBSTTree(nums, low, index-1);
		root.right = buildBSTTree(nums, index+1, high);				
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}