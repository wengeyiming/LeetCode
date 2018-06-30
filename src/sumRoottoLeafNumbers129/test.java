package sumRoottoLeafNumbers129;


public class test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}
	
    public static int sumNumbers(TreeNode root) {    
    	return getNumberByDFS(root, 0, new StringBuilder());
    }
    
    private static int getNumberByDFS(TreeNode root, int sum, StringBuilder sb) {
    	if(root == null) {
    		return 0;
    	}    	
    	sb.append(root.val);
    	if(root.left == null && root.right == null) {
    		sum += Integer.parseInt(sb.toString());
    		System.out.println(sum);
    	}

    	sum = sum + getNumberByDFS(root.left, sum, sb) + getNumberByDFS(root.right, sum, sb);
    	/*
    	 * Ϊʲô����Ǵ�ģ���Ϊ��һ��left��sum�Ѿ����12�ˣ���ʱ���ٽ���right������12�Ļ������ټ���13,Ȼ����ݻ�ȥ�ּ�12������ʹ���
    	sum += getNumberByDFS(root.left, sum, sb);
    	sum += getNumberByDFS(root.right, sum, sb);
    	*/
    	

    	sb.deleteCharAt(sb.length()-1);
    	
    	return sum;
    }
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}