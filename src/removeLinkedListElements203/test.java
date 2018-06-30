package removeLinkedListElements203;

public class test {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(6);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(6);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(6);
		temp = temp.next;
		head = removeElements(head, 6);
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
    public static ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode front = start;
        ListNode temp = head;
        while(temp != null) {
        	if(temp.val == val) {
        		ListNode next = temp.next;
        		front.next = next;
        		temp = next;
        	} else {
        		temp = temp.next;
        		front = front.next;
        	}
        	
        }
    	
    	return start.next;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}