package wordPattern290;

import java.util.*;
public class test {
	public static void main(String[] args) {
		String pattern = new String("abba");
		String str = new String("dog dog dog dog");
		System.out.println(wordPattern(pattern, str));
	}
	
    public static boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if(pattern.length() != array.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
        	if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(array[i])) {
        		map.put(pattern.charAt(i), array[i]);
        	} else {
        		if(!map.containsKey(pattern.charAt(i)) || !map.get(pattern.charAt(i)).equals(array[i])) {
        			return false;
        		}
        	}
        }
        
        return true;
    }
}
