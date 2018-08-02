package zigZagConversion6;

public class test {
	public static void main(String[] args) {
		System.out.println(convert(new String("ABCDE"), 2));
	}
	
    public static String convert(String s, int numRows) {
    	if(numRows == 0 || numRows == 1) return s;
        String[] res = new String[numRows];
        for(int i=0; i<res.length; i++) {
        	res[i] = new String("");
        }
        boolean towards = false;
        for(int i=0; i<s.length(); i++) {      	
        	int remain = i%(numRows-1);
        	if(remain == 0) {
        		towards = !towards;
        	}
        	
        	if(towards) {
        		res[remain] = res[remain] + s.charAt(i);
        	} else {
        		res[numRows-1-remain] = res[numRows-1-remain] + s.charAt(i);
        	}
        	
        }
        StringBuilder sb = new StringBuilder("");
        for(String ss : res) {
        	//System.out.print(ss+"  ");
        	sb.append(ss);
        }
        //System.out.println("");
    	return sb.toString();
    }
}
