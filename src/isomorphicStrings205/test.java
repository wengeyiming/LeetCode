package isomorphicStrings205;


import java.util.*;
public class test {
	public static void main(String[] args) {
		System.out.println(isIsomorphic(new String("a"), new String("a")));
	}
	
    public static boolean isIsomorphic(String s, String t) {
        Map m = new HashMap();
        for (Integer i=0; i<s.length(); ++i)
            if (m.put(s.charAt(i), i) != m.put(t.charAt(i), i))
                return false;
        return true;
    	
    	
    	//return twoWay(s,t) && twoWay(t,s);
    }
    
    private static boolean twoWay(String s, String t) {
        if((s == null && t != null) || (s != null && t == null) || (s.length() != t.length())) {
        	return false;
        }
        
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
        	if(!map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i), t.charAt(i));
        	} else {
        		if(map.get(s.charAt(i)) != t.charAt(i)) {
        			return false;
        		}
        	}
        }   	
    	return true;
    }
}
