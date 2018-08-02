package wallsAndGates286;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int max = Integer.MAX_VALUE;
		int[][] rooms = new int[][]
				{{max,-1,0,max},{max,max,max,-1},{max,-1,max,-1},{0,-1,max,max}};
		
		wallsAndGates(rooms);
		
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms.length; j++) {
				System.out.print(rooms[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	//BFS
    public static void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        
        while(!queue.isEmpty()) {
        	int[] top = queue.poll();
        	int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        	
        }
    }	
	
	
	//DFS
    public static void wallsAndGates1(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
		for(int i=0; i<rooms.length; i++) {
			for(int j=0; j<rooms[i].length; j++) {
				if(rooms[i][j] == 0) {
					findByDFS(rooms, i, j, 0);
				}
			}
			
		}
    }
    
    private static void findByDFS(int[][] rooms, int row, int col, int val) {
    	if(row < 0 || row >= rooms.length || col < 0 || col >= rooms[row].length || rooms[row][col] < val) {
    		return;
    	}
    	
    	rooms[row][col] = val;
    	findByDFS(rooms, row+1, col, val+1);
    	findByDFS(rooms, row-1, col, val+1);
    	findByDFS(rooms, row, col+1, val+1);
    	findByDFS(rooms, row, col-1, val+1);
    }
    
}
