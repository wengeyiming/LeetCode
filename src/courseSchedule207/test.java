package courseSchedule207;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int numCourses = 4;		
		System.out.println(canFinish(numCourses, prerequisites));
	}

	//DFS�����㷨����ӱ�־λ
	public static boolean canFinish(int numCourses, int[][] prerequisites) {     
		 ArrayList[] graph = new ArrayList[numCourses];
		 for(int i=0; i<numCourses; i++) {
			 graph[i] = new ArrayList<Integer>();
		 }
		 
		 for(int i=0; i<prerequisites.length; i++) {
			 graph[prerequisites[i][1]].add(prerequisites[i][0]);
		 }
		 //booleanĬ�ϳ�ʼ��Ϊfalse
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
		 //��Ӽ��������¼��ǰ�Ѿ����ѳɹ��Ŀγ̣����Լ���ļ�������ʱ��
		 //���ǣ�����ע������ж�Ҫ������ǰ�棬���ܷ��������forѭ��ǰ����Ϊ�������visited[course]�ᱻ��Ϊtrue�ͷ����ˣ�û���ü���Ϊfalse
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
	//���������㷨,����������BFS����
    public static boolean canFinish(int numCourses, int[][] prerequisites) {       
    	int[] graph = new int[numCourses];
    	//ȷ��ÿ����������
    	for(int i=0; i<prerequisites.length; i++) {
    		graph[prerequisites[i][0]]++;
    	}
    	
    	//���������Ϊ0�ĵ�������
    	Queue<Integer> queue = new LinkedList<>();
    	for(int i=0; i<graph.length; i++) {
    		if(graph[i] == 0) queue.add(i);
    	}   	
    	//�Ӷ�����������Ϊ0�ĵ��������ıߣ�ͬʱ�������ߺ���������Ķ�����ȼ�Ϊ0�ͼ�����У��������Ϊ0�ĵ��
    	//size+1,����ж����Ϊ0�ĵ��size�Ƿ���ڵ���������ɡ�
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
