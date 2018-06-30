package removeDuplicatesfromSortedListII82;

//此题注意：先写思路，不要怕空指针，写完总体思想再判断空指针的问题.
//在可能遇到空指针的地方，优先加条件限制，不要顾虑加上的条件会对算法主体造出影响
//深刻理解链表的原理，只有修改next才会修改结构。
//遇到要记录某个节点前面节点位置时，可以在链表head节点前新增一个节点并使其next等于head
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
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;		
		temp.next = new ListNode(5);
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
    	ListNode front = new ListNode(0);
    	front.next = head;
    	ListNode pre = front;
    	ListNode temp = head;
    	
    	while(temp != null && temp.next != null) {   		
    		//System.out.println(pre.val + " , " + temp.val + " , " + temp.next.val);	
    		if(temp.val == temp.next.val) {
    			//主要是这里的循环处理。pre记录的是上一个不重复的位置
    			while(temp.val == temp.next.val) {
    				temp = temp.next;
    				if(temp.next == null) break;
    			}    			
    			pre.next = temp.next;
    			temp = temp.next;
    		} else {
    			pre = temp;
    			temp = temp.next;
    		}   		    				
    	}	
    	return front.next;
    }
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


/*
if(head == null) {
	return null;
}
ListNode front = new ListNode(0);
front.next = head;
ListNode pre = front;
ListNode temp = head;

while(temp!= null && temp.next != null) {  		
	ListNode next = temp.next;   		
	if(temp.val == next.val) {
		while(temp.val == next.val) {
			temp = temp.next;
			next = next.next;
			if(temp.next == null) break;
		}   
		pre.next = temp.next;
		temp = temp.next;
	} else {
		pre = temp;
		temp = temp.next;
	}		
}
return front.next;
*/