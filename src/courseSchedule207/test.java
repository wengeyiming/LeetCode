package courseSchedule207;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int numCourses = 4;		
		System.out.println(canFinish(numCourses, prerequisites));
	}

	//DFS搜索算法，添加标志位
	public static boolean canFinish(int numCourses, int[][] prerequisites) {     
		 ArrayList[] graph = new ArrayList[numCourses];
		 for(int i=0; i<numCourses; i++) {
			 graph[i] = new ArrayList<Integer>();
		 }
		 
		 for(int i=0; i<prerequisites.length; i++) {
			 graph[prerequisites[i][1]].add(prerequisites[i][0]);
		 }
		 //boolean默认初始化为false
		 boolean[] visited = new boolean[numCourses];
		 
		 boolean[] memo = new boolean[numCourses];
		 
		 for(int i=0; i<numCourses; i++) {
			 if(!searchByDFS(graph, visited,memo, i)) {
				 return false;
			 }
		 }
		 
		 return true;
	}
	
	private static boolean searchByDFS(ArrayList<Integer>[] graph, boolean[] visited, boolean[]memo, int course) {
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
			 if(!searchByDFS(graph, visited,memo, graph[course].get(i))) { 
				 return false;
			 }
		 }
		 visited[course] = false;
		 memo[course] = true;
		 return true;
	}
	
	/*
	//拓扑排序算法,本质上属于BFS搜索
    public static boolean canFinish(int numCourses, int[][] prerequisites) {       
    	int[] graph = new int[numCourses];
    	//确定每个顶点的入度
    	for(int i=0; i<prerequisites.length; i++) {
    		graph[prerequisites[i][0]]++;
    	}
    	
    	//把所有入度为0的点加入队列
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i=0; i<graph.length; i++) {
    		if(graph[i] == 0) queue.add(i);
    	}   	
    	//从对列中输出入度为0的点所包含的边，同时如果输出边后与边相连的顶点入度减为0就加入队列，并且入度为0的点的
    	//size+1,最后判断入度为0的点的size是否等于点的总数即可。
    	int count = queue.size();
    	while(!queue.isEmpty()) {
    		int point = queue.poll();
        	for(int i=0; i<prerequisites.length; i++) {
        		if(prerequisites[i][1] == point) {
        			int l = prerequisites[i][0];
        			graph[l]--;
        			if(graph[l] == 0) {
        				queue.add(l);
        				count++;
        			}
        		}
        	} 		   		
    	}    	
    	return count == numCourses;
    }
    */
}
