package insertionSortList147;

public class test {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(1);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		
		head = insertionSortList(head);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}		
	}
	
    private static ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode nextNode = null;
    
        while(head != null) {
        	nextNode = head.next;
        	while(temp.next != null && temp.next.val < head.val) {
        		temp = temp.next;
        	}
        	
        	head.next = temp.next;
        	temp.next = head;
        	temp = result;
        	head = nextNode;
        }
              
        return result.next;       
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}