package removeNthNodeFromList19;

public class test {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);		
		ListNode h = head;
		for(int i=2; i<=5; i++) {
			h.next = new ListNode(i);
			h = h.next;
		}
		
		head = removeNthFromEnd(head, 1);
		
		while(head!=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	int length = 0;
    	ListNode h = head;
    	while(h!=null) {
    		h=h.next;
    		length++;
    	}
    	if(n>=length) {
    		head = head.next;
    		return head;
    	}
    	
    	h = head;
        ListNode front = head;
        ListNode end = head;
        for(int i=0; i<n-1; i++) {
        	front = front.next;
        }
        
        int num = 0;
        while(front.next!=null) {
        	front = front.next;
        	end = end.next;
        	if(num > 0) {
        		h = h.next;
        	}
        	num++;
        }
        
        h.next = end.next;
        end.next = null;
    	
    	return head;
    
    }
    
    
    
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}