package surroundedRegions130;

public class test {
	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		solve(board);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	//内部向外突破不行，考虑一下外部向内突破。对边界和所有与边界相连的O进行处理，使其变为Y，则其他的O就是被包围的，属于反向思维.
	public static void solve(char[][] board) {
		if (board == null || board.length <= 2)
			return;
		
		for(int i=0; i<board.length; i++) {
			if(i == 0 || i == board.length-1) {
				for(int j=0; j<board[i].length; j++) {
					handleEdge(board, i, j);
				}
			}
		}
		
		for(int i=0; i<board[0].length; i++) {
			if(i == 0 || i == board[0].length-1) {
				for(int j=0; j<board.length; j++) {
					handleEdge(board, j, i);
				}
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if(board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	
	private static void handleEdge(char[][] board, int row, int col) {
		if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
			if(board[row][col] == 'X' || board[row][col] == 'Y') return;			
			if(board[row][col] == 'O') {
				 board[row][col]='Y';
			}
			handleEdge(board, row+1, col);
			handleEdge(board, row-1, col);
			handleEdge(board, row, col+1);
			handleEdge(board, row, col-1);
			
		} else {
			return;
		}
	}
	
	/*
	// 这个方法超时了，考虑一下优化（似乎没法优化）
	// 添加记忆棒数组是不行的，因为记忆棒数组和原题逻辑冲突
	public static void solve(char[][] board) {
		if (board == null || board.length <= 2)
			return;
		boolean[][] visit = new boolean[board.length][board[0].length];

		boolean[][] memo = new boolean[board.length][board[0].length];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == 'O' && isSurround(board, visit, memo, row, col)) {
					board[row][col] = 'X';
				}
			}
		}
	}

	private static boolean isSurround(char[][] board, boolean[][] visit, boolean[][] memo, int row, int col) {		
		if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
			if (board[row][col] == 'X') {
				return true;
			} else {				
				if (visit[row][col])
					return true;
				visit[row][col] = true;
				boolean res = isSurround(board, visit, memo, row + 1, col)
						&& isSurround(board, visit, memo, row - 1, col) && isSurround(board, visit, memo, row, col + 1)
						&& isSurround(board, visit, memo, row, col - 1);
				visit[row][col] = false;
				return res;
			}
		} else {
			return false;
		}

	}
	*/
}
