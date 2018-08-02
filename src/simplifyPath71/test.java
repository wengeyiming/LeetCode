package simplifyPath71;

import java.util.*;


public class test {
	public static void main(String[] args) {
		String s = new String("/a/./b/../../c/");
		System.out.println(simplifyPath(s));
	}

	//原理：遇到/和.跳过，遇到..要返回到上一个目录
	public static String simplifyPath(String path) {
		Stack<String> s = new Stack<>();
		int i = 0;
		while (i < path.length()) {
			while (i < path.length() && path.charAt(i) == '/') {
				i++;
			}
			String st = "";
			while (i < path.length() && path.charAt(i) != '/') {
				st += path.charAt(i);
				i++;
			}
			
			System.out.println(st);
			if(st.equals(new String("..")) && !s.isEmpty()) {
				s.pop();
			}
			
			
			else if(!st.equals(new String("")) && !st.equals(new String(".")) && !st.equals(new String(".."))) {
				s.push(st);
			}
		}
		
		if(s.isEmpty()) return "/";
		String sb = "";
		while(!s.isEmpty()) {
			sb = "/"+s.pop()+sb;
		}
		return sb;
	}
}
