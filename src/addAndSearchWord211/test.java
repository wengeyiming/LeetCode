package addAndSearchWord211;

public class test {
	public static void main(String[] args) {
		WordDictionary dic = new WordDictionary();
		
		dic.addWord("wen");
		dic.addWord("yi");
		dic.addWord("ming");
		
		System.out.println(dic.search("yin"));
		System.out.println(dic.search("w.n"));
	}
}


class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode node = root;
        char[] a = word.toCharArray();
        for(char c : a) {
        	if(node.next[c-'a'] == null) {
        		node.next[c-'a'] = new TrieNode();
        	}
        	node = node.next[c-'a'];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	char[] a = word.toCharArray();
        return searchByBackTracking(a, root, 0);
    }
    
    private boolean searchByBackTracking(char[] a, TrieNode root, int startPos) {
    	if(startPos == a.length) return !(root.word==null);
    	if(a[startPos] != '.') {
    		return root.next[a[startPos]-'a'] != null && searchByBackTracking(a, root.next[a[startPos]-'a'], startPos+1);
    	} else {
    		for(int i=0; i<26; i++) {
    			//注意这里的回溯！
    			if(root.next[i] != null) {
    				//只要满足一条i为true，就返回true
    				//如果直接return searchByBackTracking, 那就只会判断第一条。
    				//这个是DFS，虽说也是回溯的思想，但区别在于只有满足条件的才会返回，回溯的话是每个都返回
    				if(searchByBackTracking(a, root.next[i], startPos+1)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    TrieNode root;
}


class TrieNode {
	String word;
	TrieNode[] next = new TrieNode[26];
}

