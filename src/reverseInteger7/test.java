package reverseInteger7;

public class test {
	public static void main(String[] args) {
			
		System.out.println(reverse(120) + " , " + Integer.MAX_VALUE);
	}
	
    public static int reverse(int x) {
    	int result = 0;
    	int tail = 0;
    	while(x != 0) {
    		tail = x%10;
    		result = result * 10 + tail;
    		x = x/10;	 		
    	}    	
    	//解决溢出问题
    	if(result % 10 != tail) {
    		return 0;
    	}
    	return result;
    }
}
