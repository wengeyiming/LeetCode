package multiplyStrings43;


public class test {
	public static void main(String[] args) {
		System.out.println(multiply(new String("123"), new String("10")));
	}
	
    public static String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder("");
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        
        int[] sum = new int[c1.length+c2.length];
        
        for(int i=c1.length-1; i>=0; i--) {
        	for(int j=c2.length-1; j>=0; j--) {
        		sum[i+j+1] += ((c1[i]-'0')*(c2[j]-'0'))%10;
        		if(sum[i+j+1] >= 10) {
        			sum[i+j+1] -= 10;
        			sum[i+j] += 1;
        		}
        		sum[i+j] += ((c1[i]-'0')*(c2[j]-'0'))/10;
        		if(sum[i+j] >= 10) {
        			sum[i+j] -= 10;
        			sum[i+j-1] += 1;
        		}
        	}
        }
        
        boolean zeroFlag = true;
        
        for(int i=0; i<sum.length; i++) {
        	if(sum[i] == 0) {
        		if(i==0) {
        			continue;
        		} else {
        			result.append(sum[i]);
        		}
        	} else {
        		zeroFlag = false;
        		result.append(sum[i]);
        	}   	
        }
        
        if(zeroFlag) {
        	return new String("0");
        }
        
        return result.toString();
    }	
}
