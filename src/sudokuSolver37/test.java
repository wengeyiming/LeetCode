package sudokuSolver37;

//�������Ľ⣬�����ڰ˻ʺ�����
//������ͨ������⣬һ����һ���ݹ���ݺ���+һ���ж��Ƿ�Ϸ��ĺ���
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
    						//�����ǹؼ���ÿ����һ��λ��ȷ��һ�����֣��ݹ����������ȥ
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
