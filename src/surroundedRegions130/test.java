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
	
	//�ڲ�����ͻ�Ʋ��У�����һ���ⲿ����ͻ�ơ��Ա߽��������߽�������O���д���ʹ���ΪY����������O���Ǳ���Χ�ģ����ڷ���˼ά.
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
	// ���������ʱ�ˣ�����һ���Ż����ƺ�û���Ż���
	// ��Ӽ���������ǲ��еģ���Ϊ����������ԭ���߼���ͻ
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
