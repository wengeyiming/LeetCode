package removeDuplicatesfromSortedList83;


public class test {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(1);
		temp = temp.next;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		
		head = deleteDuplicates(head);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null) {
    		return null;
    	}
    	ListNode temp = head;
    	
    	while(temp.next != null) {
    		ListNode temp1 = temp.next;
    		if(temp1.val == temp.val) {
    			temp.next = temp1.next;
    		} else {   		
    			temp = temp.next;
    		}
    	}
        return head;
    }	
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}