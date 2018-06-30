package implementStrStr28;

public class test {
	public static void main(String[] args) {
		System.out.println(strStr(new String("weng"),new String("ngd")));
	}
	
    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        
        char[] hay = haystack.toCharArray();
        char[] ne = needle.toCharArray();
        boolean flag = true;
        for(int i=0; i<haystack.length(); i++) {
        	flag = true;
        	for(int j=0;j<ne.length;j++) {
        		if(i+j==hay.length) return -1;
        		if(hay[i+j]==ne[j]) continue;
        		else {
        			flag = false;
        			break;
        		}
        	} 
        	if(flag) return i;
        }
    	return -1;
    }
}
