package balancedBinaryTree110;


public class test {
	public static void main(String[] args) {
		
	}
	
	static boolean result = true;
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
    	
        //����ֻ�����˸��ڵ�ģ���ʵӦ�ü���ÿ���ӽڵ�ġ�����Ӧ�ð��жϷŵ�����ĺ�����
        getHeight(root,0);     

    	return result;
    }
    
    private static int getHeight(TreeNode root, int height) {
    	if(root == null) {
    		return height;
    	}
    	
    	int left = getHeight(root.left, height+1);
    	int right = getHeight(root.right, height+1);
    	
    	if(Math.abs(left-right) > 1) {
    		result = false;
    	}
    	
    	return Math.max(left, right);
    }
    
    /*
    public  boolean isBalanced(TreeNode root) {
        if(root == null) return true;
    	
        int subHeight = getHeight(root.left, 0) - getHeight(root.right, 0);
        
        if(subHeight > 1 || subHeight < -1) {
        	return false;
        }
        //���ֱ��return true����ֻ�����˸��ڵ�ģ���ʵӦ�ü���ÿ���ӽڵ�ġ�����Ӧ�ð��жϷŵ�����ĺ�����
         * 
        //���εݹ��˼���˽�һ�¡�
    	return isBalanced(root.left) && isBalanced(root.right);
    }
    
    private  int getHeight(TreeNode root, int height) {
    	if(root == null) {
    		return height;
    	}
    	  	
    	return Math.max(getHeight(root.left,height+1), getHeight(root.right, height+1));
    }
    */
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}