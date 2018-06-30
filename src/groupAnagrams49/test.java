package groupAnagrams49;


//ע���HashMap���ݽṹ��ط�����Ӧ��
import java.util.*;
public class test {
	public static void main(String[] args) {
		String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
		List<List<String>> list	= groupAnagrams(strs);
		
		for(List<String> subList : list) {
			for(String s : subList) {
				System.out.print(s + " ");
			}
			System.out.println("");
		}
	}
	
    public static List<List<String>> groupAnagrams(String[] strs) {
    	//ע��Map�Ķ���
    	Map<String, List<String>> map = new HashMap<>();      
        for(int i=0; i<strs.length; i++) {
        	String s = strs[i];
        	char[] c = s.toCharArray();
        	Arrays.sort(c);
        	//ע�������һϵ�з�����
        	String key = String.valueOf(c);
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<String>());
        	}
        	map.get(key).add(s);
        }      
        //ע�������map�������ֵת��Ϊlist
    	return new ArrayList<List<String>> (map.values());
    }
}
