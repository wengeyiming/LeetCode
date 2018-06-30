package houseRobberIII337;

public class test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(0);
		System.out.println(rob(root));
	}
	

	
	//��״�ṹ��house robber,���������һ���ӽڵ�ĸ��׽ڵ㱻rob��ýڵ㲻�ܱ�rob
	//���Կ���ȥ�������ƣ��������Ϊ�������⣬Ȼ�����ǿ��Լ���һ��boolean��������ʾ�ڵ��˫�׽ڵ��Ƿ�rob
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
    		//������ע�⣬��Ҫ������һ���ڵ��Ƿ�ѡ�е��������
    		//Ȼ�����ַ����ᳬʱ����Ϊ��ε�����getMax,����һ������Ľ���취�Ƿ���һ������������Ԫ�ص�����
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
        //res[0]��ʾ������ǰ�ڵ�����ֵ��res[1]��ʾ��������ǰ�ڵ�����ֵ
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