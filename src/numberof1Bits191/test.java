package numberof1Bits191;

public class test {
	public static void main(String[] args) {
		System.out.println(hammingWeight(128));
	}
	
    public static int hammingWeight(int n) {
    	
        int num = 0;
        while(n > 0) {
        	if((n&1) != 0) {
        		num++;
        	}
        	//>>>代表无符号移位，一律补0。 >>代表有符号移位，正数补0负数补1
        	n = n>>>1;
        }
        return num;
    }
}
