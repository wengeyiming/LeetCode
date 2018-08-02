package countandSay38;

public class test {
	public static void main(String[] args) {
		System.out.println(countAndSay(2));
	}
	
    public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String s = new String("1");
		while (n > 1)
		{
			s = Count(s);
			n--;
		}
		return s;
    }
    
    private static String Count(String s) {
    	StringBuilder res = new StringBuilder();
    	int num = s.charAt(0)-'0';
    	int time = 1;
    	for(int i=1; i<s.length(); i++) {
    		if(s.charAt(i) != s.charAt(i-1)) {
    			res.append(time);
    			res.append(num);
    			num = s.charAt(i)-'0';
    			time = 1;
    		} else {
    			time++;
    		}
    	}
		res.append(time);
		res.append(num);
    	return res.toString();
    }
}
