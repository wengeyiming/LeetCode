package wordLadder127;

import java.util.*;
public class test {
	public static void main(String[] args) {
		String beginWord = new String("hit");
		String endWord = new String("cog");
		List<String> wordList = new ArrayList<>();
		wordList.add(new String("hot"));
		wordList.add(new String("dot"));
		wordList.add(new String("dog"));
		wordList.add(new String("lot"));
		wordList.add(new String("log"));
		wordList.add(new String("cog"));
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}
	
	//Dijkstra算法的变种，所有路径的权重都为1，能形成路径的两个点是只有一个字母不同的字符串
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        Set<String> reached=new HashSet<>();
        reached.add(beginWord);
        wordSet.remove(beginWord);
        int level=1;
        while(!reached.isEmpty()) {
        	Set<String> reachedNext=new HashSet<>();
        	for(String s:reached) {
        		for(int i=0;i<s.length();i++) {
        			char[] c=s.toCharArray();
        			for(char j='a';j<='z';j++) {
        				c[i]=j;
        				String newS=new String(c);
        				if(wordSet.remove(newS)) {
        					reachedNext.add(newS);
        					if(endWord.equals(newS)) return level+1;
        				}
        			}
        		}
        	}
        	reached=reachedNext;
        	level++;
        }
        return 0;
    }
}
