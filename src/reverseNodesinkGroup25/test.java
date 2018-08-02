package reverseNodesinkGroup25;

public class test {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(6);
		temp = temp.next;
		temp.next = new ListNode(7);
		temp = temp.next;
		temp = reverseKGroup(head, 3);
		
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
		System.out.println("");
	}
	
	
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null || head.next == null) {
        	return head;
        }
        ListNode first = head, last = head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode preGroup = preHead, nextGroup = preHead;
        
        int count = 1;
        while(last != null) {
        	if(count == k) {
        		nextGroup = last.next;
        		reverseList(first, last);
        		preGroup.next = last;
        		preGroup = first;
        		first.next = nextGroup;
        		first = nextGroup;
        		last = nextGroup;      		
        		count = 1;
        		continue;
        	}        	
        	count++;
        	last = last.next;
        }
        return preHead.next;
    }	
    
    private static void reverseList(ListNode head, ListNode tail) {
    	ListNode pre = new ListNode(0), node = head;
    	pre.next = head;
    	while(pre != tail) {
    		ListNode temp = node.next;
    		node.next = pre;
    		pre = node;
    		node = temp;
    	}   	
    }
	
	/*
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group: 
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list 
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
    */
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
