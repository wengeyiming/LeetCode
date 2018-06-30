package repeatedDNASequences187;

import java.util.*;
public class test {
	public static void main(String[] args) {
		String s = new String("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		List<String> list = findRepeatedDnaSequences(s);
		for(String ss : list)  {
			System.out.print(ss + " ");
		}
	}
	
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>();
		Set<String> res = new HashSet<>();
		
		for(int i=0; i<=s.length()-10; i++) {
			if(!seen.add(s.substring(i,i+10))) {
				res.add(s.substring(i,i+10));
			}
		}
		return new ArrayList<String>(res);
	}
}
