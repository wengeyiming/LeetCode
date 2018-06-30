package binaryTreeZigzagLevelOrderTraversal103;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();		
        if(root == null)  return list;
        
        zigzagBFS(list,root,0);
        return list;
    }
	
	public static void zigzagBFS(List<List<Integer>> list, TreeNode root, int level) {
		if(root == null) return;
		
		if(level >= list.size()) {
			list.add(new ArrayList<>());
		}
		
		zigzagBFS(list,root.left,level+1);
		zigzagBFS(list,root.right,level+1);
		if(level%2 == 0) {
			list.get(level).add(root.val);
		} else {
			list.get(level).add(0,root.val);
		}
		
		
	}
}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}