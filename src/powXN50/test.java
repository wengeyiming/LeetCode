package powXN50;

public class test {
	public static void main(String[] args) {
		System.out.println(myPow(2.0000,10));
	}
	
    public static double myPow(double x, int n) {
    	if(n == 0) return 1;
    	if(n == 1) return x;
        
    	if(n < 0) {
    		if(n == Integer.MIN_VALUE) {
    			//±ÜÃân*-1µÄÒç³ö
    			return myPow(x, n + 1) * myPow(x, -1); 
    		}  		
    		x = 1/x;
    		n = -n;
    	}
    	return myPow(x*x, n/2)*(n%2 == 0 ? 1 : x);
    }
}
