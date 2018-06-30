package climbingStairs70;

//最典型的动态规划问题，一次爬一步或者两步，问n步内有多少种走法
public class test {
	public static void main(String[] args) {
		System.out.println(climbStairs(9));
	}
	
	public static int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++) {
        	dp[i] = dp[i-1]+dp[i-2];
        }
        
        return dp[n];
    }
}
