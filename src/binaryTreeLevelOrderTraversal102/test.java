package binaryTreeLevelOrderTraversal102;

//实现二叉树的层序遍历
import java.util.*;
public class test {
	
	public static void main(String[] args) {
		
	}

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
        	return list;
        }   
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int size = 0;
        
        while(queue.size() > 0) {
        	//记录size的思想很不错
        	size = queue.size();
        	List<Integer> sub = new ArrayList<>();       	
        	for(int i=0; i<size; i++) {
	        	TreeNode temp = queue.poll();
	        	if(temp.left != null) {
	        		queue.add(temp.left);
	        	}
	        	if(temp.right != null) {
	        		queue.add(temp.right);
	        	}
	        	sub.add(temp.val);
        	}     	
        	list.add(sub);
        }
        
        return list;
    }
	
	/*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        helper(root, levelList, 0);
        return levelList;
    }
    
    private void helper(TreeNode node, List<List<Integer>> levelList, int level) {
        if (node == null) return;
        if (levelList.size() <= level) {
            levelList.add(new ArrayList<Integer>());
        }
        levelList.get(level).add(node.val);
        helper(node.left, levelList, level+1);
        helper(node.right, levelList, level+1);
    }
	*/
}


class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}