package validSudoku36;

//�����ֻ���������Ƿ���Ч���������Ƿ��о���⣬����ֻ��Ҫ�ж�ÿ��ÿ�����ÿ��3*3������û�������ظ�����
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
