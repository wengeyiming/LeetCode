package regularExpressionMatching10;

//字符串匹配，从头匹配和从尾匹配是一样的
import java.util.*;
public class test {
	public static void main(String[] args) {
		
		//System.out.println(isMatch(new String("aab"),new String("a*b.")));
		//System.out.println(isMatch(new String("abc"),new String("aa*bc")));
		System.out.println(isMatch(new String("aaaaaa"),new String("a*")));
		//System.out.println(isMatch(new String("s"),new String("p*")));
	}
	
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
    	boolean[][] matrix = new boolean[m+1][n+1];
    	matrix[m][n] = true;
    	
    	//首先进行尾部*字符的处理
    	for(int i=p.length()-1; i>0; i--) {
    		if(p.charAt(i) == '*') {
    			i--;
    			matrix[m][i] = true;
    		} else {
    			break;
    		}
    	}
    	
    	//然后分别对s的第i位和p的第j位进行比较
    	for(int i=s.length()-1; i>=0; i--) {
    		for(int j=p.length()-1; j>=0; j--) {
    			if(p.charAt(j)=='.' || p.charAt(j) == s.charAt(i)) {
    				matrix[i][j] = matrix[i+1][j+1];
    			} else if(p.charAt(j) == '*') {
    				j--;
    				if(matrix[i][j+2] == true) {
    					matrix[i][j] = true;
    				} else if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
    					matrix[i][j] = matrix[i+1][j];					
    				}
    			} 
    		}   		
    	}

    	
    	
    	for(int i=0; i<=m; i++) {
    		for(int j=0; j<=n; j++) {
    			System.out.print(matrix[i][j]+ " ");
    		}
    		System.out.println("");
    	}  
    	  	
    	
    	return matrix[0][0];
    	

    }
}
