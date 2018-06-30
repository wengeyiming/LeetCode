package copyListwithRandomPointer138;

import java.util.*;

public class test {
	public static void main(String[] args) {

	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;		
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}

		node = head;
		while (node != null) {
			//采用HashMap，每个原节点对应了一个新节点并存在map里，这样可以利用原节点的random指针位置找到新节点，思路很巧妙
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}
	//还有O(1) space的第三种方法，思路是新建新节点的时候把新节点放在每个原节点的后面，这样新节点的random指针就是原节点的random指针的next
	//扫描三次，第一次使链表新旧更替，第二次赋值给random，第三次断开链表
	
	/*
	//这种方法错误在于，把新链表的random指针指向了原链表（next指针指向的节点是新建的，但是random指针不知道新建的结点位置，错误的指向了原链表）
	public static RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return head;
		RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode temp = head;
		RandomListNode newTemp = newHead;
		while (temp.next != null) {
			newTemp.next = new RandomListNode(temp.next.label);
			temp = temp.next;
			newTemp = newTemp.next;
		}
		newTemp.next = null;
		newTemp = newHead;
		temp = head;
		while (temp != null) {
			newTemp.random = temp.random;
			temp = temp.next;
			newTemp = newTemp.next;
		}
		return newHead;
	}
	*/

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};