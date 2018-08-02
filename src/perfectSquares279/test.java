package perfectSquares279;

public class test {
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}

	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			int j = 1;
			int min = Integer.MAX_VALUE;
			while (i - j * j >= 0) {
                min = Math.min(min, dp[i-j*j]+1);
                j++;
			}
			dp[i] = min;
			
			for(int m=1; m<=n; m++) {
				System.out.print(dp[m]+" ");
			}
			System.out.println("");
		}
		return dp[n];
	}
}
