package convertSortedListtoBinarySearchTree109;


public class test {
	public static void main(String[] args) {
		
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;        
        TreeNode root = buildTree(head, null);        
        return root;
    }
    
    //此题从Array变成了LinkedList.其实可以遍历一遍List把数值存到一个Array里,但是还是用LinkedList的方法解决
    //注意比较LinkedList和Array的区别.
    private static TreeNode buildTree(ListNode head, ListNode tail) {
    	
    	ListNode slow = head;
    	ListNode fast = head;
    	
    	if(head == tail) return null;
    	
    	while(fast != tail && fast.next != tail) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	TreeNode root = new TreeNode(slow.val);
    	
    	root.left = buildTree(head, slow);
    	root.right = buildTree(slow.next, tail);
    	
    	
    	return root;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
