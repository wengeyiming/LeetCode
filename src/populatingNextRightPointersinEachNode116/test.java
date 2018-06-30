package populatingNextRightPointersinEachNode116;

import java.util.*;
public class test {
	public static void main(String[] args) {
		
	}
	
    public static void connect(TreeLinkNode root) {
    	if(root == null) return;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = root.next != null ? root.next.left : null;
            connect(root.left);
            connect(root.right);
        }
    }	
    
    
}


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}