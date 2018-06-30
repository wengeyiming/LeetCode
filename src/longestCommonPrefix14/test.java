package longestCommonPrefix14;
import java.util.*;

//String.indexOf(str),返回子字符串str在一个String里首次出现的位置
public class test {
	public static void main(String[] args) {
		String[] strs = new String[]{"wen"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) return "";	
    	String str = strs[0];
    	for(int i=0; i<strs.length; i++) {
    		while(strs[i].indexOf(str) != 0) {
    			str = str.substring(0, str.length()-1);
    		} 		
    	}
    	
        return str;
    }
}
