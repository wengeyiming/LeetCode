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
					//注意这里的new
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);					
				}
				//不能这样写，因为要实现的是对原graph的深拷贝，所以要新建节点，这个还是复制的原节点
				//temp.neighbors.add(neighbor);
				
				//这样写才是对的，因为map里保存的是新节点，所以都要从map里读取
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