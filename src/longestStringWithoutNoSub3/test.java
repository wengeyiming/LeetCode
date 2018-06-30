package longestStringWithoutNoSub3;

import java.util.*;
//买一个本子，记下题目的类型和变种，做好总结
//比如这个题是字符串类型的题。要求连续的最长不重复子序列，那么如果不连续的话应该怎么求
public class test {
	
	public static void main(String[] args) {
		String s = new String("ab");		
		System.out.println(lengthOfLongestSubstring(s));
		s = "aab";
		System.out.println(lengthOfLongestSubstring(s));
		s = "abb";
		System.out.println(lengthOfLongestSubstring(s));
		s = "abba";
		System.out.println(lengthOfLongestSubstring(s));
		s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
		s = "aaabcaddba";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
    public static int lengthOfLongestSubstring(String s) {   
        char[] c = s.toCharArray();    
        if(c.length <= 1) return c.length;
        int length = 0;   
        int maxLength = 0;       
        int startLoc = 0;        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<c.length; i++) {
        	if(map.containsKey(c[i])) {   
        		if(map.get(c[i])+1 > startLoc) {
        			startLoc = map.get(c[i])+1;
        		}
        	}
        	//the old value will be replaced
        	map.put(c[i], i);
        	length = i-startLoc+1;
        	if(length > maxLength) {
        		maxLength = length;
        	}
        	length = 0;
        }

        return maxLength;
    }
}
