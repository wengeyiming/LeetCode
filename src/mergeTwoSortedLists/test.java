package mergeTwoSortedLists;

public class test {
	public static void main(String[] args) {
		
	}
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode h = head;
        
        while(l1!=null && l2!=null) {
        	if(l1.val <= l2.val) {
        		h.next = l1;
        		l1 = l1.next;
        	} else {
        		h.next = l2;
        		l2 = l2.next;       		
        	}
    		h = h.next;    	
        }
        
        while(l1!=null) {
    		h.next = l1;
        }
        while(l2!=null) {
    		h.next = l2;
        }      
        return head.next;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}