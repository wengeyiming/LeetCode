package binaryTreePaths257;

import java.util.*;
public class test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<String> list = binaryTreePaths(root);
		
		for(String s : list) {
			System.out.print(s + " ");
		}
	}
	
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPathByDFS(root, list, new String(""));
        return list;
    }
    
    private static void getPathByDFS(TreeNode root, List<String> list, String s) {
    	if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(s+root.val);
            return;
        }
        
        s = s+root.val;
        if(root.left != null) {
        	getPathByDFS(root.left, list, s+"->");
        }
        if(root.right != null) {
        	getPathByDFS(root.right, list, s+"->");
        }
    }
    
	/*
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        getPathByDFS(root, list, new StringBuilder(""));
        return list;
    }
     
    private static void getPathByDFS(TreeNode root, List<String> list, StringBuilder sb) {       
        //这个题最好不要用StringBuilder,因为要是这样的话输出一条路径还得删除，太麻烦了
    	if(root == null) return;
        if(root.left == null && root.right == null) {
            list.add(new StringBuilder(sb.append(root.val)).toString());
            return;
        }
        
        sb.append(root.val+"");
        if(root.left != null) {
        	getPathByDFS(root.left, list, new StringBuilder(sb.append("->")));
        	sb.delete(sb.length()-2, sb.length());
        }
        if(root.right != null) {
        	getPathByDFS(root.right, list, new StringBuilder(sb.append("->")));
        	sb.delete(sb.length()-2, sb.length());
        }
    }
   */
    

    
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}