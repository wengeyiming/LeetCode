package palindromeLinkedList234;

public class test {
	public static void main(String[] args) {
		
	}
	
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        
        slow = reverseList(slow);
        
        fast = head;
        
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    private static ListNode reverseList(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
    	ListNode temp = head;
    	
    	while(temp!= null && temp.next != null) {
    		ListNode heads = h.next;
    		ListNode m = temp.next;
    		h.next = m;
    		temp.next = m.next;
    		m.next = heads;   		
    	}
        
        
    	return h.next;        
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}