package getRectangleFromMatrix;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0,0,1,1,1,0,0,0},{0,0,1,1,1,0,0,0},{0,0,0,0,1,1,0,0},
			{0,0,0,0,1,1,0,0},{1,1,0,0,0,0,0,0},{1,1,0,0,0,0,0,0}};
			
		List<String> list = getAllRectangle(matrix);
		
		for(String s : list) {
			System.out.print(s+"   ");
		}
		
		System.out.println("");
	}
	
	private static List<String> getAllRectangle(int[][] matrix) {
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j] == 1) {
					getMatrixByDFS(matrix, i, j, new String(i+","+j+" "));
				}
			}
		}
		
		return null;
	}
	
	private static void getMatrixByDFS(int[][] matrix, int row, int col, String s) {
		ArrayList<String>[] list = new ArrayList[10];
		list[0].add(new String("213"));
		
		
	}
}
