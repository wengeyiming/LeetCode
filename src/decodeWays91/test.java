package decodeWays91;

public class test {
	public static void main(String[] args) {
		
		System.out.println(numDecodings(new String("22233222322")));
	}
	
	
    public static int numDecodings(String s) {
    	
    	if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
    	
    	char[] c = s.toCharArray();
    	int[] dp = new int[c.length];
    	dp[0] = 1;
    	boolean isOne = false;
    	boolean isTwo = false;
    	if(c[0] == '1' ) {
    		isOne = true;
    	} else if(c[0] == '2') {
    		isTwo = true;
    	}  	  	 
    
    	for(int i=1; i<c.length; i++) {
    		int num = 0;   	
    		dp[i] = (c[i] != '0' ? dp[i-1]: 0);
    		if(isOne || (isTwo && c[i] <= '6')) {
    			//这里的判断是核心
    			if( i-2 >= 0) {
    				//为何加的是dp[i-2]，原因在于这个时候最后两位可以合起来组成一个编码，这样就多了dp[i-2]种类型的编码
                    num = dp[i-2];
                } else {
                	num = 1;
                }    	
    			dp[i] += num;
    		}
    		if(c[i] == '1') {
    			isOne = true;
    			isTwo = false;
    		} else if(c[i] == '2'){
    			isTwo = true;
    			isOne = false;
    		} else {
    			isOne = false;
    			isTwo = false;
    		}
    	}
    	
    	for(int i=0; i<dp.length; i++) {
    		System.out.print(dp[i]+" ");
    	}
    	System.out.println("");
    	
        return dp[dp.length-1];
    }
}
