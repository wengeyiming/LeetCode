package findModeinBinarySearchTree501;


import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static int[] findMode(TreeNode root) {
    	if(root == null) return new int[0];
    	
    	int max = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();    
        findByBFS(root, map, max);       
        
        int[] result = new int[list.size()];         
        for(int key: map.keySet()){
            if(map.get(key) == max) list.add(key);
        }
        for(int i=0; i<list.size(); i++) {
        	result[i] = list.get(i);
        }
    	return result;
    }
    
    private static void findByBFS(TreeNode root, Map<Integer, Integer> map, int max) {   	
    	if(root.left != null) {
    		findByBFS(root.left,map,max);
    	}   	
    	map.put(root.val, map.getOrDefault(root.val, 0)+1);
    	max = Math.max(max, map.get(root.val));
       	if(root.left != null) {
    		findByBFS(root.right,map,max);
    	}
    }
}


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}


/*
public class Solution {
    Map<Integer, Integer> map; 
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[0]; 
        this.map = new HashMap<>(); 
        
        inorder(root); 
        
        List<Integer> list = new LinkedList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max) list.add(key);
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i<res.length; i++) res[i] = list.get(i);
        return res; 
    }
    
    private void inorder(TreeNode node){
        if(node.left!=null) inorder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0)+1);
        max = Math.max(max, map.get(node.val));
        if(node.right!=null) inorder(node.right); 
    }
}
*/
