package uniqueBinarySearchTreesII95;

import java.util.*;
public class test {
	public static void main(String[] args) {
		List<TreeNode> list = generateTrees(3);
		
		System.out.println("size: " + list.size());
		for(TreeNode root : list) {
			printTree(root);
			System.out.println("");	
		}
	}
	
	
	
	
	
	private static void printTree(TreeNode root) {
		if(root == null) {
			return;		
		}
		
		System.out.print(root.val+" ");
		printTree(root.left);
		printTree(root.right);

		
	}
	
    public static List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }
    
    private static List<TreeNode> generateTrees(int s, int e) {
        List<TreeNode> result = new ArrayList<>();
        //Ϊ������Ҫ��һ��null?
        if (s > e) {
            result.add(null);
            return result;
        }
        List<TreeNode> leftSub, rightSub;
        for(int i=s; i<=e; i++) {
            leftSub = generateTrees(s, i - 1);
            rightSub = generateTrees(i + 1, e);
                      
            //������߼��о�һ��
            for (TreeNode leftNode : leftSub) {
            	System.out.println("left");
                for (TreeNode rightNode : rightSub) {
                	System.out.print("right  ");
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
                System.out.println("");
            }
        	
        }
        
        for(TreeNode node : result) {        	
        	System.out.print(node.val+"  ");        	
        }

        return result;
        
    }
}

  
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}



/*
System.out.println("left");
for(TreeNode l : leftSub) {
	printTree(l);
	System.out.println("");	
}
System.out.println("right");
for(TreeNode r : rightSub) {
	printTree(r);
	System.out.println("");	
}   
*/