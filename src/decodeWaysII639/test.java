package decodeWaysII639;

public class test {
	public static void main(String[] args) {
		System.out.println(numDecodings(new String("*1*")));
	}
	
	public static int numDecodings(String s) {
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;
		
        for(int i=2; i<dp.length; i++) {

        	dp[i] = (ways(s.charAt(i-1))*dp[i-1]+ ways(s.charAt(i-2),s.charAt(i-1))*dp[i-2])%1000000007;
        }
        
        for(int i=0; i<dp.length; i++) {
        	System.out.print(dp[i]+" ");
        }
        System.out.println("");
		return (int) dp[dp.length-1];
    }
	
    private static int ways(int ch) {
        if(ch == '*') return 9;
        if(ch == '0') return 0;
        return 1;
    }
    //最后两位结合能够额外形成的组合
    private static int ways(char ch1, char ch2) {
        String str = "" + ch1 + "" + ch2;
        if(ch1 != '*' && ch2 != '*') {
            if(Integer.parseInt(str) >= 10 && Integer.parseInt(str) <= 26)
                return 1;
        } else if(ch1 == '*' && ch2 == '*') {
            return 15;
        } else if(ch1 == '*') {
            if(Integer.parseInt(""+ch2) >= 0 && Integer.parseInt(""+ch2) <= 6)
                return 2;
            else
                return 1;
        } else {
            if(Integer.parseInt(""+ch1) == 1 ) {
                return 9;
            } else if(Integer.parseInt(""+ch1) == 2 ) {
                return 6;
            } 
        }
        return 0;
    }
}
