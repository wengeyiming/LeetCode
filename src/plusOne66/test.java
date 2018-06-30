package plusOne66;


public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{8,9,8,9};
		
		int[] result = plusOne(nums);
		
		for(int n : result) {
			System.out.print(n+" ");
		}
	}
	
    public static int[] plusOne(int[] digits) {
    	for(int i=digits.length-1; i>=0; i--) {
	    	if(digits[i] != 9) {
	    		digits[i]++;
	    		return digits;
	    	}
	    	digits[i]=0;
    	}
    	
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }	
}
