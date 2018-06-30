package removeInvalidParentheses301;

import java.util.*;
public class test {
	public static void main(String[] args) {
		String s = new String(")(f");
		List<String> list = removeInvalidParentheses(s);
		System.out.println("result: ");
		for(String ss : list) {
			System.out.println(ss+" ");
		}
		System.out.println("");
	}
	
	private static int minOp;
    public static List<String> removeInvalidParentheses(String s) {
    	List<String> list = new ArrayList<>();
    	Set<String> set = new HashSet<>();
    	minOp = Integer.MAX_VALUE;
    	findByDFS(list, s, 0, 0, 0, new String(""),0, set);
    	//findByDFS(list, s, 0, 0, 0, new StringBuilder(""),0, set);
    	return list;
    }
    
    
    private static void findByDFS(List<String> list, String s, int loc, 
    		int leftNum, int rightNum, String sb, int op, Set<String> set) {
    	if(leftNum < rightNum) return;
    	if(loc == s.length()) {  		
    		if(leftNum == rightNum) {
    			if(op <= minOp) {
    				if(op < minOp) {
    					list.clear();
    					minOp = op;
    				}
    				if(set.add(sb)) {
    					list.add(sb);
    				}
    			}
    		}
    		return;
    	}
    	char c = s.charAt(loc);
    	if(c == '(') {
    		//Ϊʲô������StringBuilder �ͻ�����أ�
    		//��Ϊ������������return������������return��sb����¼ӵĶ���Ӧ��ȫ��ɾ��������֮����
    		findByDFS(list, s, loc+1, leftNum+1, rightNum, sb+"(", op, set);
    		findByDFS(list, s, loc+1, leftNum, rightNum, sb, op+1, set);   		
    	} else if(c == ')') {
    		findByDFS(list, s, loc+1, leftNum, rightNum+1, sb+")", op, set);
    		findByDFS(list, s, loc+1, leftNum, rightNum, sb, op+1, set);  		
    	} else {
    		findByDFS(list, s, loc+1, leftNum, rightNum, sb+c, op, set);
    	}
    }
    
    /*
    private static void findByDFS(List<String> list, String s, int loc, 
    		int leftNum, int rightNum, StringBuilder sb, int op, Set<String> set) {
    	if(leftNum < rightNum) {
    		return;
    	}
    	if(loc == s.length()) {
    		
    		if(leftNum == rightNum) {
    			System.out.println(leftNum + "," + rightNum);
    			System.out.println(op + "," + sb.toString()+ "," + minOp);
    			if(op <= minOp) {
    				if(op < minOp) {
    					list.clear();
    					minOp = op;
    				}
    				if(set.add(sb.toString())) {
    					list.add(sb.toString());
    				}
    			}
    		} 
    		return;
    	}
    	System.out.println("sb: " + sb.toString()+",loc: " + loc);
    	char c = s.charAt(loc);
    	if(c == '(') {
    		sb.append(c);
    		findByDFS(list, s, loc+1, leftNum+1, rightNum, sb, op, set);
    		sb.deleteCharAt(sb.length()-1);
    		findByDFS(list, s, loc+1, leftNum, rightNum, sb, op+1, set);   		
    	} else if(c == ')') {
    		sb.append(c);
    		findByDFS(list, s, loc+1, leftNum, rightNum+1, sb, op, set);
    		sb.deleteCharAt(sb.length()-1);
    		findByDFS(list, s, loc+1, leftNum, rightNum, sb, op+1, set);  		
    	} else {
    		sb.append(c);
    		findByDFS(list, s, loc+1, leftNum, rightNum, sb, op, set);
    		
    		//���ﲻ���� �ͻ�������������ַ������Ҳ�����ݹ�ʱ��������StringBuilder��ֱ����String����
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    */
}
