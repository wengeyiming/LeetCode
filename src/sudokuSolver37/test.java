package sudokuSolver37;

//求数独的解，类似于八皇后问题
//这种求通解的问题，一般有一个递归回溯函数+一个判断是否合法的函数
import java.util.*;
public class test {
	public static void main(String[] args) {
		char[][] board = new char[][]{
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		
		solveSudoku(board);
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
    public static void solveSudoku(char[][] board) { 	
    	solve(board);
    }	 
    
    public static boolean solve(char[][] board){   
    	
    	for(int i=0; i<9; i++) {
    		for(int j=0; j<9; j++) {
    			if(board[i][j] == '.') {   				
    				for(int k=1; k<=9; k++) {
    					char c = (char)(k+'0');
    					if(isValid(board,i,j,c)) {
    						board[i][j] = c; 
    						//这里是关键，每次在一个位置确定一个数字，递归回溯搜索下去
    						if(solve(board)) {
    							return true;
    						}
    						else {
        						board[i][j] = '.';  
        					}
    					} 
    				}   				
    				return false;
    			}
    		}
    	}    	    	
    	return true;
    }
    
    private static boolean isValid(char[][] board, int row, int col, char c){    	
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    	

    }
}
