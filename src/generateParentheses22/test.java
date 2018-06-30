package generateParentheses22;
import java.util.*;

//有特殊顺序规定的回溯搜索
public class test {
	public static void main(String[] args) {
		
		List<String> list = generateParenthesis(4);
		for(String s : list) {
			System.out.println(s);
		}
	}	
	
    public static List<String> generateParenthesis(int n) {    	
    	List<String> list = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	findByBackTracking(0,0,n,list,sb);
        return list;
    }
    
    public static void findByBackTracking(int left, int right,int all, List<String> list, StringBuilder sb) {
    	if(right == all) {
    		list.add(sb.toString());
    	}
    	if(left<all) {
    		sb.append('(');
    		findByBackTracking(left+1,right,all,list,sb);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	if(right<left && right < all) {
    		sb.append(')');
    		findByBackTracking(left,right+1,all,list,sb);
    		sb.deleteCharAt(sb.length()-1);   			
    	}
    }
}
