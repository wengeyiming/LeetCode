package cloneGraph133;

import java.util.*;

public class test {
	public static void main(String[] args) {

	}

	// BFS
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
		map.put(newNode.label, newNode);
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode temp = queue.poll();
			for (UndirectedGraphNode neighbor : temp.neighbors) {
				if(!map.containsKey(neighbor.label)) {
					//ע�������new
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);					
				}
				//��������д����ΪҪʵ�ֵ��Ƕ�ԭgraph�����������Ҫ�½��ڵ㣬������Ǹ��Ƶ�ԭ�ڵ�
				//temp.neighbors.add(neighbor);
				
				//����д���ǶԵģ���Ϊmap�ﱣ������½ڵ㣬���Զ�Ҫ��map���ȡ
			    map.get(temp.label).neighbors.add(map.get(neighbor.label)); 
			}
		}
		return newNode;	
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};