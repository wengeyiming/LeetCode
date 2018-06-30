package reverseLinkedListII92;

import java.util.*;
public class test {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		/*
		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(6);
		temp = temp.next;
		*/
		
		//head = reverseWhole(head);
		head = reverseBetween(head, 1, 2);
		while(head != null) {
			System.out.print(head.val + "  ");
			head = head.next;
		}
		System.out.println("");
	}
	
	
    public static ListNode reverseWhole(ListNode head) {
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
	
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
    	ListNode front = null,end = null;
    	
    	ListNode temp = head;
    	int i = 0;
    	while(temp != null) {
    		i++;
    		if(i == m-1) {
    			front = temp;
    		}
    		if(i == n+1) {
    			end = temp;
    		}
    		temp = temp.next;   		
    	}
    	
    	//注意非空情况的处理
    	if(front != null) {
    		temp = front.next;
    	} else {
    		front = h;
    		temp = head;
    	}
        while(temp != null  && temp.next != end) {
    		ListNode heads = front.next;
    		ListNode k = temp.next;
    		front.next = k;
    		temp.next = k.next;
    		k.next = heads;   
        }
        
        if(temp != null) {
        	temp.next = end;
        }
        
        
        
    	return h.next;
    }
}


class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}