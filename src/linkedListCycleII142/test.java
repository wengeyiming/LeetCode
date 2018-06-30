package linkedListCycleII142;

public class test {
	public static void main(String[] args) {
		
	}
	
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (slow == null || fast == null ||fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
        } while(slow != fast);
        
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast; 
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}