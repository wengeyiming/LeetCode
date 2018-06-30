package addBinary67;

public class test {
	
	public static void main(String[] args) {
		System.out.println(addBinary(new String("111"), new String("10000")));
	}
	
    public static String addBinary(String a, String b) {
    	char[] aa = a.toCharArray();
    	char[] bb = b.toCharArray();
    	
    	int la = aa.length-1;
    	int lb = bb.length-1;
    	int flag = 0;
    	StringBuilder sb =  new StringBuilder();
    	while(la>=0 && lb>=0) {
    		int n1 = (aa[la]-'0');
    		int n2 = (bb[lb]-'0');    			
    		sb.append((n1+n2+flag)%2);    		
    		flag = (n1+n2+flag)>1 ? 1:0; 		
    		la--;
    		lb--;
    	}   	
    	while(la >= 0) {
    		int n1 = (aa[la]-'0');
    		sb.append((n1+flag)%2);  
    		flag = (n1+flag)>1 ? 1:0; 
    		la--;
    	}
    	while(lb >= 0) {
    		int n2 = (bb[lb]-'0');    			
    		sb.append((n2+flag)%2);    		
    		flag = (n2+flag)>1 ? 1:0; 		
    		lb--;  		
    	}
        if(flag > 0) {
        	sb.append(flag);
        }
        //注意这里要翻转一下，因为是从后往前加的，而结果显示是从前往后
        return sb.reverse().toString();
    }	
}
