package zeroOneMatrix542;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
		
		int[][] newMatrix = updateMatrix(matrix);
		for(int i=0; i<newMatrix.length; i++) {
			for(int j=0; j<newMatrix[0].length; j++) {
				System.out.print(newMatrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(11);
	}
	
    public static int[][] updateMatrix(int[][] matrix) {
    	if(matrix == null || matrix.length == 0) return matrix;

        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[0].length; j++) {
        		if(matrix[i][j] != 0 && !hasNeiberZero(i, j, matrix)) {
        			matrix[i][j] = Integer.MAX_VALUE-1;
        		}
        	}
        }

        for(int i=0; i<matrix.length; i++) {
        	for(int j=0; j<matrix[0].length; j++) {
        		if(matrix[i][j] == 1 ) {
        			getMinDistance(matrix, i, j, 0);
        		}
        	}
        }
        
    	return matrix;
    }
    
    private static void getMinDistance(int[][] matrix, int row, int col, int val) {
    	//当遇到边界值判断时，把边界值判断放最前面
    	if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
    			|| matrix[row][col] <= val) return;
        if(val>0) matrix[row][col] = val;
        
        getMinDistance(matrix, row+1, col, matrix[row][col]+1);
        getMinDistance(matrix, row-1, col, matrix[row][col]+1);
        getMinDistance(matrix, row, col+1, matrix[row][col]+1);
        getMinDistance(matrix, row, col-1, matrix[row][col]+1);
    	
    }
    
    private static boolean hasNeiberZero(int x, int y, int[][] matrix){
        if(x>0&&matrix[x-1][y]==0) return true;
        if(x<matrix.length-1&&matrix[x+1][y]==0) return true;
        if(y>0&&matrix[x][y-1]==0) return true;
        if(y<matrix[0].length-1&&matrix[x][y+1]==0) return true;
        
        return false;
    }
}
