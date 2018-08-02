package gameofLife289;

public class test {
	public static void main(String[] args) {
		int[][] board = new int[][]{
			{0,1,0},{0,0,1},{1,1,1},{0,0,0}
		};
		gameOfLife(board);
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
	}
		
    public static void gameOfLife(int[][] board) {
    	if(board == null || board.length == 0) return;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				int count = getValue(board, i-1, j-1) + getValue(board, i, j-1) + getValue(board, i+1, j-1) 
				+ getValue(board, i-1, j) + getValue(board, i+1, j) + getValue(board, i-1, j+1)
				+ getValue(board, i, j+1) + getValue(board, i+1, j+1);
				//System.out.print(count+" ,");
				changeValue(board, i, j, count);
			}
		} 
		/*
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		*/
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j] == 2) board[i][j] = 0;
				if(board[i][j] == 3) board[i][j] = 1;
			}
		}  
    }
    
    private static void changeValue(int[][] board, int i, int j, int count) {
    	if(count < 2) {
    		if(board[i][j] == 1) board[i][j] = 2;
    	} else if(count > 3) {
    		if(board[i][j] == 1) board[i][j] = 2;
    	} else if(count == 3) {
    		if(board[i][j] == 0) board[i][j] = 3;
    	} else {}
    }
    
    private static int getValue(int[][] board, int row, int col) {
    	if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
    		return 0;
    	} else if(board[row][col] == 1 || board[row][col] == 2) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
}
