package partitionList86;


public class test {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(2);
		temp = temp.next;
		
		head = partition(head, 3);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode greater = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode great = greater;
        ListNode small = smaller;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                small.next = current;
                small = current;
            } else {
                great.next = current;
                great = current;
            }
            current = current.next;
        }
        great.next = null;
        small.next = greater.next;
        return smaller.next;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}