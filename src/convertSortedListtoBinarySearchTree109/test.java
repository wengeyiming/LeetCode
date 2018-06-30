package convertSortedListtoBinarySearchTree109;


public class test {
	public static void main(String[] args) {
		
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;        
        TreeNode root = buildTree(head, null);        
        return root;
    }
    
    //�����Array�����LinkedList.��ʵ���Ա���һ��List����ֵ�浽һ��Array��,���ǻ�����LinkedList�ķ������
    //ע��Ƚ�LinkedList��Array������.
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
