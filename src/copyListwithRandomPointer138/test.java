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
			//����HashMap��ÿ��ԭ�ڵ��Ӧ��һ���½ڵ㲢����map�������������ԭ�ڵ��randomָ��λ���ҵ��½ڵ㣬˼·������
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}
	//����O(1) space�ĵ����ַ�����˼·���½��½ڵ��ʱ����½ڵ����ÿ��ԭ�ڵ�ĺ��棬�����½ڵ��randomָ�����ԭ�ڵ��randomָ���next
	//ɨ�����Σ���һ��ʹ�����¾ɸ��棬�ڶ��θ�ֵ��random�������ζϿ�����
	
	/*
	//���ַ����������ڣ����������randomָ��ָ����ԭ����nextָ��ָ��Ľڵ����½��ģ�����randomָ�벻֪���½��Ľ��λ�ã������ָ����ԭ����
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