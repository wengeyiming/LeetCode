package searcha2DMatrixII240;

public class test {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
		System.out.println(searchMatrix(matrix, 20));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int row = 0;
		int col = matrix[0].length - 1;
		
		while(col >= 0 && row <= matrix.length-1) {
			if(matrix[row][col] == target) {
				return true;
			} else if(matrix[row][col] < target) {
				row++;
			} else {
				col--;
			}
			System.out.println(row+","+col);
		}
		
		return false;
	}
}
