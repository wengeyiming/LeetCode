package stringToInteger8;

//字符串转为整数
public class test {
	public static void main(String[] args) {
		System.out.println(myAtoi(new String("   -91283472332")));
	}
	
	//负数处理问题，越界问题
    public static int myAtoi(String str) {
        char[] c = str.trim().toCharArray();
        boolean minus = false;
        
        
        int num = 0;
        for(int i=0; i<c.length; i++) {
        	if(i==0 && c[i] == '-') {
        		minus = true;
        	} else if(i==0 && c[i] == '+') {
        		minus = false;
        	} else if((c[i]-'0') >=0 && (c[i]-'0') <= 9) { 
        		//因为超过最大值数值就会变得很奇怪，所以用最大值除10来判断，算是反向思维
        		if (num > Integer.MAX_VALUE / 10
    					|| (num == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < (c[i]-'0')))
        		{
    				return !minus ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        		}
        		else {
        			num = num*10 + (c[i]-'0');  
        		}

        	} else {
        		break;
        	}
        }
    	
    	
    	return minus? -num : num;
    }
}
