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
	
	//BFSʵ�����ˣ�˼���ǻ���ÿ���������ȡ�
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
	//DFSʵ�����ˣ�˼���ǻ���ÿ������ĳ��ȡ�
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
			 if(!searchByDFS(graph, visited,memo, graph[course].get(i), order)) { 
				 return false;
			 }
		 }
		 //ֻҪÿ�ζ��ѽ��������ǰ�漴��ʵ�����������ԭ���������˳���������ʵ�ֵ��߼�
		 order.add(0,course);
		 visited[course] = false;
		 memo[course] = true;
		 return true;
    }
    */
}
