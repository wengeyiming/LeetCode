package removeDuplicatesfromSortedListII82;

//����ע�⣺��д˼·����Ҫ�¿�ָ�룬д������˼�����жϿ�ָ�������.
//�ڿ���������ָ��ĵط������ȼ��������ƣ���Ҫ���Ǽ��ϵ���������㷨�������Ӱ��
//�����������ԭ��ֻ���޸�next�Ż��޸Ľṹ��
//����Ҫ��¼ĳ���ڵ�ǰ��ڵ�λ��ʱ������������head�ڵ�ǰ����һ���ڵ㲢ʹ��next����head
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
    			//��Ҫ�������ѭ������pre��¼������һ�����ظ���λ��
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