package uniquePathsTwo63;


//带有障碍物的路径种类求法
public class test {
	public static void main(String[] args) {
		int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
	
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
        	return 0;
        }        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        
        dp[0][0] = 1;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			dp[i][j] = 0;
        		} else {
	        		if(i!=0 && j!=0) {
	        			dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        		} else if(i==0 && j!=0) {
	        			dp[i][j] = dp[i][j-1];
	        		} else if(j==0 && i!=0) {
	        			dp[i][j] = dp[i-1][j];
	        		}
        		}
        	}
        }
        return dp[m-1][n-1];
    }
}
