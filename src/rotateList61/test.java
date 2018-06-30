package rotateList61;

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

		
		head = rotateRight(head, 3);
		
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		
	}
	
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
       
        ListNode current = head;
        int listNum = 0;
        while(current != null) {
        	listNum++;
        	current = current.next;
        }
        
        listNum = listNum - k % listNum;
        current = head;
       // System.out.println(listNum);
        ListNode greater = new ListNode(0);
        ListNode smaller = new ListNode(0);
        ListNode great = greater;
        ListNode small = smaller;
        
        int now = 0;
        while (current != null) {
            if (now < listNum) {
                small.next = current;
                small = current;
            } else {
                great.next = current;
                great = current;
            }
            now++;
            current = current.next;
        }
        great.next = smaller.next;
        small.next = null;
        return greater.next;        
    }

}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}