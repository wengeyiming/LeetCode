package bullsandCows299;

import java.util.*;
public class test {
	public static void main(String[] args) {
		String secret = new String("1123");
		String guess = new String("0111");
		System.out.println(getHint(secret, guess));
	}
	
    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        for(Character c : s) {
        	map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        for(Character c : g) {
        	map2.put(c, map2.getOrDefault(c, 0)+1);
        }
        
        int BCount = 0;
        for(int i=0; i<s.length; i++) {
        	if(map1.get(s[i]) != null && map2.get(s[i]) != null)  {
        		BCount += Math.min(map1.get(s[i]), map2.get(s[i]));
        		map1.put(s[i], 0);
      
        	}
        }
        
        int ACount = 0;
        for(int i=0; i<s.length; i++) {
        	if(s[i] == g[i])  {
        		BCount--;
        		ACount++;
        	}
        }
        
        
    	return ACount + "A" + BCount + "B";
    }
}
