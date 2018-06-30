package coinChangeII;

public class test {
	public static void main(String[] args) {
		int[] coins = new int[] { 1, 2, 5 };
		//for(int i=0; i<=5; i++) {
			System.out.println(change(6, coins));
		//}
	}

	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;// 初始的时候要组合中0元钱，有1中组合方式。
		// 硬币的面值在外循环，这样保证之前用过的面值不会再被使用
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= amount; j++) {
				dp[j] += dp[j - coins[i]];			
			}
			for(int m=0; m<dp.length; m++) {
				System.out.print(dp[m]+" ");
			}	
			System.out.println("");
		}

		return dp[amount];
	}
}
