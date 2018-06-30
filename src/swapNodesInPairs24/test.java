package swapNodesInPairs24;
import java.util.*;

//难点在于需要第三个指针来定位前一对数字的后面那个的位置，以便确定下一组交换数字的上一个指针地址
public class test {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);		
		ListNode h = head;
		for(int i=1; i<1; i++) {
			h.next = new ListNode(i);
			h = h.next;
		}		
		head = swapPairs(head);		
		while(head!=null) {
			System.out.print(head.val+" ");
			head = head.next;
		}
		
	}
	
    public static ListNode swapPairs(ListNode head) {
    	if( head == null || head.next == null) {
    		return head;
    	} 

    	ListNode front = head.next;
    	ListNode rear = head;
    	ListNode now = rear;
    	int num=0;
    	while(front!=null) {
    		rear.next = front.next;
    		front.next = rear;
    		    		
    		ListNode m = front;
    		front = rear;
    		rear = m;
    		if(num == 0) {
    			head = rear;
    		}
    		if(num > 0) {
    			now.next = rear;
    		}
    		num++;
    		now = front;
    		if(front.next != null) {
    			rear = rear.next.next;
    			if(front.next.next == null) {
    				return head;  				
    			}
    			front = front.next.next;  			
    		} else {
    			return head;
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