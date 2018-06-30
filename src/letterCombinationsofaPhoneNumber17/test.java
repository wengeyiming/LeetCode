package letterCombinationsofaPhoneNumber17;

import java.util.*;
//����.��������. DFS,�ѵ����ں����ṹ�Ĵ���
//���ɣ�1���������庯����Ӧ�ã�void��������+���ô���List<String>
//2��StringBuilder��ʹ�ã�ע��ɾ���õ�deleteCharAt
//3��c[now]��һ��'6'�������ַ����ֵĸ�ʽ��ע��Ҫ��ȡ���������Ҫ��ȥ'0'
//4������keyboard�����������жϵ����˼�롣
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
