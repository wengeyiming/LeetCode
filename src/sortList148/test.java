package sortList148;

public class test {
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode temp = head;
		temp.next = new ListNode(2);
		temp = temp.next;
		temp.next = new ListNode(1);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		
		head = sortList(head);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}
	
    public static ListNode sortList(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	ListNode pre = null;
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	//������ô��⣬���е�linkedlistȡ�е㶼��ȡ����ָ�룬һ��������һ����һ��.
    	while(fast != null && fast.next != null) {
    		pre = slow;
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	//����ܹؼ�����ΪlistҪ�����ݣ�����Ҫ���м�Ͽ�
    	pre.next = null;
    	
    	//���϶��ֵݹ飬Ȼ��鲢����
    	ListNode l1 = sortList(head);
    	ListNode l2 = sortList(slow);    	
    	head = mergeTwoList(l1, l2);
    	
    	return head;
    }
    
    private static ListNode mergeTwoList(ListNode l1, ListNode l2) {
    	ListNode l = new ListNode(0);
    	ListNode temp = l;
    	while(l1 != null && l2 != null) {
    		if(l1.val <= l2.val) {
    			l.next = l1;
    			l1 = l1.next;
    		} else {
    			l.next = l2;
    			l2 = l2.next;
    		}
    		l = l.next;
    	}
    	if(l1 != null) {
    		l.next = l1;
    	}
    	if(l2 != null) {
    		l.next = l2;
    	}
    	return temp.next;
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}