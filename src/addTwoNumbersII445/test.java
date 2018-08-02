package addTwoNumbersII445;

import java.util.*;
public class test {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(7);
		ListNode temp = l1;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		temp = l2;		
		temp.next = new ListNode(6);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = addTwoNumbers(l1, l2);
		
		//temp = reverseLinkedList(l1);
		
		while(temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println("");
		
	}
	
	//不使用ReverseList,也就是不改变链表本身(用两个stack,代码略)
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		
		
		return node.next;
	}
	
	
	/*
	//使用ReverseList
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
    	
        l1 = reverseLinkedList(l1);
        l2 = reverseLinkedList(l2);
        
		ListNode cur = node;
		int bflag = 0;
		List<Integer> list = new ArrayList<>();
		while (l1 != null || l2 != null) {
			int x = (l1 == null) ? 0 : l1.val;
			int y = (l2 == null) ? 0 : l2.val;
			int val = (x+y+bflag)%10;
			list.add(0,val);
			bflag = (x+y+bflag)/10;
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		if(bflag != 0) {
			list.add(0,bflag);
		}
		
		for(Integer n : list) {
			cur.next = new ListNode(n);
			cur = cur.next;
		}
		return node.next;
    }
    */
    
    
    private static ListNode reverseLinkedList(ListNode head) {    
    	ListNode h = new ListNode(0);
    	h.next = head;
    	ListNode temp = head;
    	while(temp != null && temp.next != null) {
    		ListNode m = temp.next;
    		ListNode heads = h.next;   		
    		h.next = m;
    		temp.next = m.next;
    		m.next = heads;  		
    	}
    	
    	return h.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}