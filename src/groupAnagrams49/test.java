package groupAnagrams49;


//注意对HashMap数据结构相关方法的应用
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
    	//注意Map的定义
    	Map<String, List<String>> map = new HashMap<>();      
        for(int i=0; i<strs.length; i++) {
        	String s = strs[i];
        	char[] c = s.toCharArray();
        	Arrays.sort(c);
        	//注意这里的一系列方法名
        	String key = String.valueOf(c);
        	if(!map.containsKey(key)) {
        		map.put(key, new ArrayList<String>());
        	}
        	map.get(key).add(s);
        }      
        //注意这里的map里的所有值转化为list
    	return new ArrayList<List<String>> (map.values());
    }
}
