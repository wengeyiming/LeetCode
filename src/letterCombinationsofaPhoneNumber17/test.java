package letterCombinationsofaPhoneNumber17;

import java.util.*;
//回溯.排列问题. DFS,难点在于函数结构的处理
//技巧：1、回溯主体函数的应用：void返回类型+引用传递List<String>
//2、StringBuilder的使用，注意删除用的deleteCharAt
//3、c[now]是一个'6'这样的字符数字的格式，注意要获取里面的数字要减去'0'
//4、构造keyboard数组来减少判断的设计思想。
public class test {
	public static void main(String[] args) {
		List<String> list = letterCombinations(new String(""));		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	public static List<String> letterCombinations(String digits) {
		String[] keyboard = new String[]{"", "", "abc", "def","ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> lists = new ArrayList<>();
        char[] c = digits.toCharArray();
        if(c.length == 0) return lists;
        findAll(lists,c,0,new StringBuilder(),keyboard);
        return lists;
    }
	
	public static void findAll(List<String> lists, char[] c, int now, StringBuilder sb, String[] keyboard) {
		if(now == c.length) {
			lists.add(sb.toString());
			return;
		} else {
			char[] m = keyboard[c[now]-'0'].toCharArray();
			for(int i=0; i<m.length; i++) {
				sb.append(m[i]);
				findAll(lists,c,now+1,sb,keyboard);
				sb.deleteCharAt(sb.length()-1);
			}
		}		
	}
}
