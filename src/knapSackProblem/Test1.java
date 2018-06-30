package knapSackProblem;

public class Test1 {
	public static void main(String[] args) {
		int[] value = new int[] { 1, 4, 5, 7 };
		int[] weight = new int[] { 1, 3, 4, 5 };
		//int[] value = new int[] { 5, 7, 1, 4 };
		//int[] weight = new int[] { 4, 5, 1, 3 };	
		int maxWeight = 7;
		System.out.println(zeroOneKnapSackProblem(value, weight, maxWeight));
	}

	public static int zeroOneKnapSackProblem(int[] value, int[] weight, int maxWeight) {
		int[][] dp = new int[value.length][maxWeight+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=1; j<dp[0].length; j++) {
				if(j < weight[i]) {
					if(i>0) {
						dp[i][j] = dp[i-1][j];
					} else {
						dp[i][j] = 0;
					}
				} else {		
					if(i>0) {
						dp[i][j] = Math.max( dp[i-1][j], value[i]+dp[i-1][j-weight[i]]);
					} else {
						dp[i][j] = value[i];
					}
				}
			}			
		}		
				
		int[] dp1 = new int[maxWeight+1];
		for(int i=0; i<value.length; i++) {
			for(int j=weight[i]; j<=maxWeight; j++) {
				dp1[j] = Math.max(dp1[j], dp1[j-weight[i]]+value[i]);
			}
		}
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
		
		
		for(int i=0; i<dp1.length; i++) {
			System.out.print(dp1[i]+" ");
		}
		System.out.println("");
		return dp[value.length-1][maxWeight];
	}
}
