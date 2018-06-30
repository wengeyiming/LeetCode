package courseScheduleII210;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2},{1,3}};
		int numCourses = 4;		
		int[] order = findOrder(numCourses, prerequisites);
		if(order != null) {
			for(int o : order) {
				System.out.print(o + " ");
			}
		}
	}
	
	//BFS实现拓扑，思想是基于每个顶点的入度。
	public static int[] findOrder(int numCourses, int[][] prerequisites) {      		
		int[] inDegree = new int[numCourses];
		for(int i=0; i<prerequisites.length; i++) {
			inDegree[prerequisites[i][0]]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		for(int i=0; i<numCourses; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
				res.add(i);
			}
		}
		int size = queue.size();
		
		while(!queue.isEmpty()) {
			int course = queue.poll();
			for(int i=0; i<prerequisites.length; i++) {
				if(prerequisites[i][1] == course) {					
					inDegree[prerequisites[i][0]]--;
					if(inDegree[prerequisites[i][0]] == 0) {
						res.add(prerequisites[i][0]);
						queue.add(prerequisites[i][0]);
						size++;
					}
				}
			}
		}
		if(size != numCourses) {
			return new int[0];
		}				
		int[] order = new int[numCourses];
		for(int i=0; i<numCourses; i++) {
			order[i] = res.get(i);
		}
		return order;
	}
	
	/*
	//DFS实现拓扑，思想是基于每个顶点的出度。
    public static int[] findOrder(int numCourses, int[][] prerequisites) {               
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
		for(int i=0; i<numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}
        for(int i=0; i<prerequisites.length; i++) {
        	graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] memo = new boolean[numCourses];
        
        ArrayList<Integer> orders = new ArrayList<>();
        int[] order = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
        	if(!searchByDFS(graph, visited, memo, i, orders)) {
        		return new int[0];
        	}   	
        }
        for(int i=0; i<orders.size(); i++) {
        	order[i] = orders.get(i);
        }
        
        return order;
    }
    
    private static boolean searchByDFS(ArrayList<Integer>[] graph, boolean[] visited, boolean[] memo,int course,
    		ArrayList<Integer> order) {
		 //添加记忆棒，记录以前已经深搜成功的课程，可以极大的减少运行时间
		 //但是，必须注意这个判断要放在最前面，不能放在下面的for循环前，因为如果那样visited[course]会被置为true就返回了，没来得及变为false
		 if(memo[course]) {
			 return true;
		 }
		 if(visited[course]) {
			 return false;
		 } else {
			 visited[course] = true;
			 
		 }
		 for(int i=0; i<graph[course].size(); i++) {
			 if(!searchByDFS(graph, visited,memo, graph[course].get(i), order)) { 
				 return false;
			 }
		 }
		 //只要每次都把结果扔在最前面即可实现拓扑输出，原因在于这个顺序就是拓扑实现的逻辑
		 order.add(0,course);
		 visited[course] = false;
		 memo[course] = true;
		 return true;
    }
    */
}
