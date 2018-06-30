package validSudoku36;

//这个题只用求数独是否有效而不用求是否有具体解，所以只需要判断每行每列外加每个3*3格子有没有数字重复即可
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
		System.out.println(isValidSudoku(board));
	}
	
    public static boolean isValidSudoku(char[][] board) {	
        Set<String> set = new HashSet<>();
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		if(board[i][j] != '.') {
        			String b = '('+board[i][j]+")";
	        		if(!set.add(b+j)||!set.add(i+b)||!set.add(i/3+b+j/3)) {
	        			return false;
	        		}
        		}
        	}
        }
              
    	return true;
    }
}
