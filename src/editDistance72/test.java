package editDistance72;

//求从一个字符串转换为另一个字符串需要的最小次数，是一道Hard难度的动态规划题
public class test {
	public static void main(String[] args) {
		System.out.println(minDistance(new String("horse"), new String("ros")));
	}
	
    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
    	int m = c1.length;
    	int n = c2.length;
    	int[][] dp = new int[m+1][n+1];
    	
    	
    	for(int i=1; i<=m; i++) {
    		dp[i][0] = i;
    	}
    	for(int j=1; j<=n; j++) {
    		dp[0][j] = j;
    	}
    	dp[0][0] = 0;
    	for(int i=1; i<=m; i++) {
    		for(int j=1; j<=n; j++) {
    			int delete = dp[i-1][j] + 1;
    			int add = dp[i][j-1] + 1;
    			int replace = dp[i-1][j-1] + (c1[i-1] == c2[j-1] ? 0 : 1);
    			dp[i][j] = Math.min(replace ,Math.min(delete, add));
    		}    		
    	}
    	
    	/*
    	for(int i=0; i<=m; i++) {
    		for(int j=0; j<=n; j++) {
    			System.out.print(dp[i][j] + " ");
    		}    		
    		System.out.println("");
    	}
    	*/
    	return dp[m][n];
    }
}
