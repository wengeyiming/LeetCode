package houseRobberIII337;

public class test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(0);
		System.out.println(rob(root));
	}
	

	
	//树状结构的house robber,限制是如果一个子节点的父亲节点被rob则该节点不能被rob
	//可以考虑去除该限制，则问题变为深搜问题，然后我们可以加上一个boolean变量来表示节点的双亲节点是否被rob
    public static int rob(TreeNode root) {
        int res = Math.max(getMax(root,true),getMax(root,false));       
        return res;
    }
    
    private static int getMax(TreeNode root, boolean flag) {
    	if(root == null) {
    		return 0;
    	}
    	int a=0;
    	int b=0;
    	if(flag) {
    		a = root.val + getMax(root.left,false)+getMax(root.right,false);
    	} else {
    		//这里需注意，需要考虑下一个节点是否选中的两种情况
    		//然而这种方法会超时，因为多次调用了getMax,所以一个巧妙的解决办法是返回一个包含了两个元素的数组
    		b = Math.max(getMax(root.left,true),getMax(root.left,false))+Math.max(getMax(root.right,true),getMax(root.right,false));
    	} 	
    	return Math.max(a, b);
    	
    }
    /*
    public static int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    private static int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] res = new int[2];
        //res[0]表示包含当前节点的最大值，res[1]表示不包含当前节点的最大值
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        
        res[0] = x.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        return res;
    }
    */
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}