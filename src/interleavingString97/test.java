package interleavingString97;

public class test {
	public static void main(String[] args) {
		String s1 = new String("aabcc");
		String s2 = new String("dbbca");
		String s3 = new String("aadbbcbcac");
		
		System.out.println(isInterleave(s1,s2,s3));
	}
	
    public static boolean isInterleave(String s1, String s2, String s3) {
    	
        int memo[][] = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return findByRecursive(s1, 0, s2, 0, s3, 0, memo);
    }	
	
    public static boolean findByRecursive(String s1, int i, String s2, int j, String s3, int k, int[][] memo) {
    	if(i == s1.length()) {
    		return s2.substring(j).equals(s3.substring(k));
    	}
    	if(j == s2.length()) {
    		return s1.substring(i).equals(s3.substring(k));
    	}
    	
    	if(memo[i][j] >= 0) {
    		return memo[i][j] == 1 ? true : false;
    	}
    	
    	boolean flag = false;
    	
    	flag = (findByRecursive(s1, i+1, s2, j, s3, k+1, memo)&&s3.charAt(k) == s1.charAt(i)) ||
    			(findByRecursive(s1, i, s2, j+1, s3, k+1, memo)&&s3.charAt(k) == s2.charAt(j));
    	
    	memo[i][j] = flag ? 1:0;
    	
    	return flag;
    }
    /*
    public static boolean isInterleave(String s1, String s2, String s3) {
        
    	if(s1.length()+s2.length() != s3.length()) return false;
    	boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
            	if(i==0 && j==0) dp[i][j] = true;
            	else if(i==0 && j!=0) {
            		dp[i][j] = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            	} else if(i!=0 && j==0) {
            		dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
            	} else {
            		dp[i][j] = (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1));
            	}
            }
        }
    	
        for(int i=0; i<=s1.length(); i++) {
        	for (int j = 0; j <= s2.length(); j++) {
            	System.out.print(dp[i][j]+" ");       		
        	}
        	System.out.println("");
        }
        
    	return dp[s1.length()][s2.length()];
    }
    */
}
