package rangeSumQuery2D304;

public class test {
	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };

		NumMatrix(matrix);
	}

	public static void NumMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return;
		int[][] dp = new int[matrix.length][matrix[0].length];
		//dp[0][0] = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dp[i][j] += matrix[i][j];
				if(i>0) dp[i][j] += dp[i-1][j];
				if(j>0) dp[i][j] += dp[i][j-1];
				if(i>0 && j>0) dp[i][j] -= dp[i-1][j-1];
				//dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + matrix[i][j];
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
